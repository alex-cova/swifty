package com.swifty.exception;

import com.swifty.domain.node.expression.Argument;
import com.swifty.domain.scope.Scope;

import java.util.List;

/**
 * Created by Alex
 */
public class MethodSignatureNotFoundException extends RuntimeException {
    public MethodSignatureNotFoundException(Scope scope, String methodName, List<Argument> parameterTypes) {
        super("There is no method '" + methodName + "' with parameters " + parameterTypes);
    }
}
