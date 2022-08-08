package com.swifty.exception;

import com.swifty.domain.node.expression.Expression;

/**
 * Created by Alex
 */
public class ComparisonBetweenDiferentTypesException extends RuntimeException {
    public ComparisonBetweenDiferentTypesException(Expression leftExpression, Expression rightExpression) {
        super("Comparison between types " + leftExpression.type() + " and " + rightExpression.type() + " not yet supported");
    }
}
