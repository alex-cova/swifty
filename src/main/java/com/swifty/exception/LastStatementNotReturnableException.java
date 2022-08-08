package com.swifty.exception;

import com.swifty.domain.node.statement.Statement;

/**
 * Created by Alex
 */
public class LastStatementNotReturnableException extends RuntimeException {
    public LastStatementNotReturnableException(Statement lastStatement) {
        super("The statement " + lastStatement + " is a last statement in a functon, but it is not an expression!");
    }
}
