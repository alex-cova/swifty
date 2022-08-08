package com.swifty.parsing.visitor;

import com.swifty.domain.ClassDeclaration;
import com.swifty.domain.Constructor;
import com.swifty.domain.Function;
import com.swifty.domain.MetaData;
import com.swifty.domain.node.expression.ConstructorCall;
import com.swifty.domain.node.expression.FunctionCall;
import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.node.statement.Block;
import com.swifty.domain.scope.Field;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.BultInType;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alex
 */
public class ClassVisitor extends SwiftyBaseVisitor<ClassDeclaration> {

    private Scope scope;

    @Override
    public ClassDeclaration visitClassDeclaration(@NotNull SwiftyParser.ClassDeclarationContext ctx) {
        MetaData metaData = new MetaData(ctx.className().getText(), "java.lang.Object");
        scope = new Scope(metaData);
        String name = ctx.className().getText();
        FieldVisitor fieldVisitor = new FieldVisitor(scope);
        FunctionSignatureVisitor functionSignatureVisitor = new FunctionSignatureVisitor(scope);
        List<SwiftyParser.FunctionContext> methodsCtx = ctx.classBody().function();
        List<Field> fields = ctx.classBody().field().stream()
                .map(field -> field.accept(fieldVisitor))
                .peek(scope::addField)
                .collect(toList());
        methodsCtx.stream()
                .map(method -> method.functionDeclaration().accept(functionSignatureVisitor))
                .forEach(scope::addSignature);
        boolean defaultConstructorExists = scope.isParameterLessSignatureExists(name);
        addDefaultConstructorSignatureToScope(name, defaultConstructorExists);
        List<Function> methods = methodsCtx.stream()
                .map(method -> method.accept(new FunctionVisitor(scope)))
                .collect(toList());
        if (!defaultConstructorExists) {
            methods.add(getDefaultConstructor());
        }
        boolean startMethodDefined = scope.isParameterLessSignatureExists("init");
        if (startMethodDefined) {
            methods.add(getGeneratedMainMethod());
        }

        return new ClassDeclaration(name, fields, methods);
    }

    private void addDefaultConstructorSignatureToScope(String name, boolean defaultConstructorExists) {
        if (!defaultConstructorExists) {
            FunctionSignature constructorSignature = new FunctionSignature(name, Collections.emptyList(), BultInType.VOID);
            scope.addSignature(constructorSignature);
        }
    }

    private Constructor getDefaultConstructor() {
        FunctionSignature signature = scope.getMethodCallSignatureWithoutParameters(scope.getClassName());
        return new Constructor(signature, Block.empty(scope));
    }

    private Function getGeneratedMainMethod() {
        Parameter args = new Parameter("args", BultInType.STRING_ARR, null);
        FunctionSignature functionSignature = new FunctionSignature("main", Collections.singletonList(args), BultInType.VOID);
        ConstructorCall constructorCall = new ConstructorCall(scope.getClassName());
        FunctionSignature startFunSignature = new FunctionSignature("init", Collections.emptyList(), BultInType.VOID);
        FunctionCall startFunctionCall = new FunctionCall(startFunSignature, Collections.emptyList(), scope.getClassType());
        Block block = new Block(new Scope(scope), Arrays.asList(constructorCall, startFunctionCall));
        return new Function(functionSignature, block);
    }
}
