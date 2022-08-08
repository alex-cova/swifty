package com.swifty.validation;

public enum ArgumentErrors {
    NONE(""),
    NO_FILE("Specify files for compilation"),
    BAD_FILE_EXTENSION("File has to end with .swift extension");

    private final String message;

    ArgumentErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
