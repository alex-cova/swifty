package com.swifty.parsing.visitor.expression;

import com.swifty.domain.CompareSign;
import com.swifty.domain.node.expression.ConditionalExpression;
import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.expression.Value;
import com.swifty.domain.type.BultInType;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;

public class ConditionalExpressionVisitor extends SwiftyBaseVisitor<ConditionalExpression> {
    private final ExpressionVisitor expressionVisitor;

    public ConditionalExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public ConditionalExpression visitConditionalExpression(@NotNull SwiftyParser.ConditionalExpressionContext ctx) {
        SwiftyParser.ExpressionContext leftExpressionCtx = ctx.expression(0);
        SwiftyParser.ExpressionContext rightExpressionCtx = ctx.expression(1);
        Expression leftExpression = leftExpressionCtx.accept(expressionVisitor);
        Expression rightExpression = rightExpressionCtx != null ? rightExpressionCtx.accept(expressionVisitor) : new Value(BultInType.INT, "0");
        CompareSign cmpSign = ctx.cmp != null ? CompareSign.fromString(ctx.cmp.getText()) : CompareSign.NOT_EQUAL;
        return new ConditionalExpression(leftExpression, rightExpression, cmpSign);
    }
}
