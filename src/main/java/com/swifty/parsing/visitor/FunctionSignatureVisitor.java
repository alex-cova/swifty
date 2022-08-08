package com.swifty.parsing.visitor;

import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.Type;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import com.swifty.parsing.visitor.expression.function.ParameterExpressionListVisitor;
import com.swifty.util.TypeResolver;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex
 */
public class FunctionSignatureVisitor extends SwiftyBaseVisitor<FunctionSignature> {

    private final ExpressionVisitor expressionVisitor;

    public FunctionSignatureVisitor(Scope scope) {
        this.expressionVisitor = new ExpressionVisitor(scope);
    }

    @Override
    public FunctionSignature visitFunctionDeclaration(@NotNull SwiftyParser.FunctionDeclarationContext ctx) {

        String functionName = ctx.functionName() == null ? "init" : ctx.functionName().getText();

        Type returnType = TypeResolver.getFromTypeContext(ctx.type());

        SwiftyParser.ParametersListContext parametersCtx = ctx.parametersList();

        if (parametersCtx != null) {
            List<Parameter> parameters = parametersCtx.accept(new ParameterExpressionListVisitor(expressionVisitor));
            return new FunctionSignature(functionName, parameters, returnType);
        }
        return new FunctionSignature(functionName, Collections.emptyList(), returnType);

    }
}
