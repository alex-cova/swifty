package com.swifty.exception;

import com.swifty.domain.node.expression.Expression;

/**
 * Created by Alex
 */
public class UnsupportedRangedLoopTypes extends RuntimeException {
    public UnsupportedRangedLoopTypes(Expression startExpression, Expression endExpression) {
        super("Only integer types are supported so far");
    }
}
