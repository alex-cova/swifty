package com.swifty.exception;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.expression.arthimetic.ArthimeticExpression;

/**
 * Created by Alex
 */
public class UnsupportedArthimeticOperationException extends RuntimeException {
    public UnsupportedArthimeticOperationException(ArthimeticExpression expression) {
        super(prepareMesage(expression));
    }

    private static String prepareMesage(ArthimeticExpression expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        return "Unsupported arthimetic operation between " + leftExpression +" and "+rightExpression;
    }
}
