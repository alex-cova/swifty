package com.swifty.parsing.visitor;

import com.swifty.domain.Constructor;
import com.swifty.domain.Function;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.scope.LocalVariable;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.statement.StatementVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Alex
 */
public class FunctionVisitor extends SwiftyBaseVisitor<Function> {

    private final Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunction(@NotNull SwiftyParser.FunctionContext ctx) {
        FunctionSignature signature = ctx.functionDeclaration().accept(new FunctionSignatureVisitor(scope));
        scope.addLocalVariable(new LocalVariable("this",scope.getClassType()));
        addParametersAsLocalVariables(signature);
        Statement block = getBlock(ctx);
        if(signature.name().equals(scope.getClassName())) {
            return new Constructor(signature,block);
        }
        return new Function(signature, block);
    }

    private void addParametersAsLocalVariables(FunctionSignature signature) {
        signature.parameters().stream()
                .forEach(param -> scope.addLocalVariable(new LocalVariable(param.name(), param.type())));
    }

    private Statement getBlock(SwiftyParser.FunctionContext functionContext) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        SwiftyParser.BlockContext block = functionContext.block();
        return block.accept(statementVisitor);
    }
}
