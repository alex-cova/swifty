package com.swifty.exception;

import com.swifty.domain.node.expression.Call;

/**
 * Created by Alex
 */
public class BadArgumentsToFunctionCallException extends RuntimeException {
    public BadArgumentsToFunctionCallException(Call functionCall) {
        super("You called function with bad arguments " + functionCall);
    }
}
