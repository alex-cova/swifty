package com.swifty.exception;

import com.swifty.domain.scope.FunctionSignature;

/**
 * Created by Alex
 */
public class MethodWithNameAlreadyDefinedException extends RuntimeException {
    public MethodWithNameAlreadyDefinedException(FunctionSignature signature) {
        super("Method already defined in scope :" + signature);
    }
}
