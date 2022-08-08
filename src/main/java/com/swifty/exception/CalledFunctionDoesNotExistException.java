package com.swifty.exception;

import com.swifty.domain.node.expression.FunctionCall;
import com.swifty.domain.scope.Scope;

/**
 * Created by Alex
 */
public class CalledFunctionDoesNotExistException extends CompilationException {
    private final FunctionCall functionCall;

    public CalledFunctionDoesNotExistException(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public CalledFunctionDoesNotExistException(FunctionCall functionCall, ReflectiveOperationException e) {
        this(functionCall);
    }

    public CalledFunctionDoesNotExistException(FunctionCall functionCall, Scope scope) {
        this(functionCall);
    }

    @Override
    public String getMessage() {
        return "Function call" + functionCall.toString() + "does not exists";
    }
}
