package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.EmptyExpression;
import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.ReturnStatement;
import com.swifty.domain.type.BultInType;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class ReturnStatementVisitor extends SwiftyBaseVisitor<ReturnStatement> {
    private final ExpressionVisitor expressionVisitor;

    public ReturnStatementVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public ReturnStatement visitReturnVoid(@NotNull SwiftyParser.ReturnVoidContext ctx) {
        return new ReturnStatement(new EmptyExpression(BultInType.VOID));
    }

    @Override
    public ReturnStatement visitReturnWithValue(@NotNull SwiftyParser.ReturnWithValueContext ctx) {
        Expression expression = ctx.expression().accept(expressionVisitor);
        return new ReturnStatement(expression);
    }
}
