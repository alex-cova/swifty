package com.swifty.domain;

public record CompilationUnit(ClassDeclaration classDeclaration) {

    public String getClassName() {
        return classDeclaration.name();
    }
}
