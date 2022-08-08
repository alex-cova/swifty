package com.swifty.domain.node.expression;


import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.CompareSign;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;
import com.swifty.exception.MixedComparisonNotAllowedException;

/**
 * Created by Alex
 */
public class ConditionalExpression implements Expression {

    private final CompareSign compareSign;
    private final Expression leftExpression;
    private final Expression rightExpression;
    private final Type type;
    private final boolean isPrimitiveComparison;

    public ConditionalExpression(Expression leftExpression, Expression rightExpression,CompareSign compareSign) {
        this.type = BultInType.BOOLEAN;
        this.compareSign = compareSign;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        boolean leftExpressionIsPrimitive = leftExpression.type().getTypeClass().isPrimitive();
        boolean rightExpressionIsPrimitive = rightExpression.type().getTypeClass().isPrimitive();
        isPrimitiveComparison = leftExpressionIsPrimitive && rightExpressionIsPrimitive;
        boolean isObjectsComparison =  !leftExpressionIsPrimitive && !rightExpressionIsPrimitive;
        boolean isMixedComparison = !isPrimitiveComparison && !isObjectsComparison;
        if (isMixedComparison) {
            throw new MixedComparisonNotAllowedException(leftExpression.type(), rightExpression.type());
        }
    }

    public CompareSign getCompareSign() {
        return compareSign;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public boolean isPrimitiveComparison() {
        return isPrimitiveComparison;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}

