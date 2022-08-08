package com.swifty.exception;

import com.swifty.domain.scope.Scope;

/**
 * Created by Alex
 */
public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException(Scope scope, String fieldName) {
        super("No field found for name " + fieldName + " found in scope" + scope);
    }
}
