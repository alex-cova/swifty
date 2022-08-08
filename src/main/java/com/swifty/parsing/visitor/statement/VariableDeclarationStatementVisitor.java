package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.VariableDeclaration;
import com.swifty.domain.scope.LocalVariable;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class VariableDeclarationStatementVisitor extends SwiftyBaseVisitor<VariableDeclaration> {
    private final ExpressionVisitor expressionVisitor;
    private final Scope scope;

    public VariableDeclarationStatementVisitor(ExpressionVisitor expressionVisitor, Scope scope) {
        this.expressionVisitor = expressionVisitor;
        this.scope = scope;
    }

    @Override
    public VariableDeclaration visitVariableDeclaration(@NotNull SwiftyParser.VariableDeclarationContext ctx) {
        String varName = ctx.name().getText();
        SwiftyParser.ExpressionContext expressionCtx = ctx.expression();
        Expression expression = expressionCtx.accept(expressionVisitor);
        scope.addLocalVariable(new LocalVariable(varName, expression.type()));
        return new VariableDeclaration(varName, expression);
    }
}
