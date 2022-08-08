package com.swifty.parsing.visitor.expression;

import com.swifty.domain.node.expression.*;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.function.CallExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class ExpressionVisitor extends SwiftyBaseVisitor<Expression> {

    private final ArithmeticExpressionVisitor arithmeticExpressionVisitor;
    private final VariableReferenceExpressionVisitor variableReferenceExpressionVisitor;
    private final ValueExpressionVisitor valueExpressionVisitor;
    private final CallExpressionVisitor callExpressionVisitor;
    private final ConditionalExpressionVisitor conditionalExpressionVisitor;

    public ExpressionVisitor(Scope scope) {
        arithmeticExpressionVisitor = new ArithmeticExpressionVisitor(this);
        variableReferenceExpressionVisitor = new VariableReferenceExpressionVisitor(scope);
        valueExpressionVisitor = new ValueExpressionVisitor();
        callExpressionVisitor = new CallExpressionVisitor(this, scope);
        conditionalExpressionVisitor = new ConditionalExpressionVisitor(this);
    }

    @Override
    public Expression visitVarReference(@NotNull SwiftyParser.VarReferenceContext ctx) {
        return variableReferenceExpressionVisitor.visitVarReference(ctx);
    }

    @Override
    public Expression visitValue(@NotNull SwiftyParser.ValueContext ctx) {
        return valueExpressionVisitor.visitValue(ctx);
    }

    @Override
    public Expression visitFunctionCall(@NotNull SwiftyParser.FunctionCallContext ctx) {
        return callExpressionVisitor.visitFunctionCall(ctx);
    }

    @Override
    public Expression visitConstructorCall(@NotNull SwiftyParser.ConstructorCallContext ctx) {
        return callExpressionVisitor.visitConstructorCall(ctx);
    }

    @Override
    public Expression visitSupercall(@NotNull SwiftyParser.SupercallContext ctx) {
        return callExpressionVisitor.visitSupercall(ctx);
    }

    @Override
    public Expression visitAdd(@NotNull SwiftyParser.AddContext ctx) {

        return arithmeticExpressionVisitor.visitAdd(ctx);
    }

    @Override
    public Expression visitMultiply(@NotNull SwiftyParser.MultiplyContext ctx) {

        return arithmeticExpressionVisitor.visitMultiply(ctx);
    }

    @Override
    public Expression visitSubstract(@NotNull SwiftyParser.SubstractContext ctx) {

        return arithmeticExpressionVisitor.visitSubstract(ctx);
    }

    @Override
    public Expression visitDivide(@NotNull SwiftyParser.DivideContext ctx) {

        return arithmeticExpressionVisitor.visitDivide(ctx);
    }

    @Override
    public ConditionalExpression visitConditionalExpression(@NotNull SwiftyParser.ConditionalExpressionContext ctx) {
        return conditionalExpressionVisitor.visitConditionalExpression(ctx);
    }
}
