package com.swifty.exception;

import com.swifty.domain.scope.Scope;

/**
 * Created by Alex
 */
public class LocalVariableNotFoundException extends RuntimeException {
    public LocalVariableNotFoundException(Scope scope, String variableName) {
        super("No local varaible found for name " + variableName + " found in scope" + scope);
    }
}
