package com.swifty.domain.node.expression.arthimetic;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public abstract class ArthimeticExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;
    private final Type type;

    protected ArthimeticExpression(Expression leftExpression, Expression rightExpression) {
        this.type = getCommonType(leftExpression,rightExpression);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    private static Type getCommonType(Expression leftExpression, Expression rightExpression) {
        if(rightExpression.type() == BultInType.STRING) return BultInType.STRING;
        return leftExpression.type();
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public Type type() {
        return type;
    }
}
