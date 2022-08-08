package com.swifty.parsing.visitor.expression;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.expression.arthimetic.*;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;


public class ArithmeticExpressionVisitor extends SwiftyBaseVisitor<ArthimeticExpression> {
    private final ExpressionVisitor expressionVisitor;

    public ArithmeticExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public ArthimeticExpression visitAdd(@NotNull SwiftyParser.AddContext ctx) {
        SwiftyParser.ExpressionContext leftExpression = ctx.expression(0);
        SwiftyParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Addition(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitMultiply(@NotNull SwiftyParser.MultiplyContext ctx) {
        SwiftyParser.ExpressionContext leftExpression = ctx.expression(0);
        SwiftyParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Multiplication(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitSubstract(@NotNull SwiftyParser.SubstractContext ctx) {
        SwiftyParser.ExpressionContext leftExpression = ctx.expression(0);
        SwiftyParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Substraction(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitDivide(@NotNull SwiftyParser.DivideContext ctx) {
        SwiftyParser.ExpressionContext leftExpression = ctx.expression(0);
        SwiftyParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Division(leftExpress, rightExpress);
    }
}
