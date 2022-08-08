package com.swifty.exception;

/**
 * Created by Alex
 */
public class ClassNotFoundForNameException extends RuntimeException {
    public ClassNotFoundForNameException(String className) {
        super("class not found " + className);
    }
}
