package com.swifty.bytecodegeneration;

import com.swifty.domain.ClassDeclaration;
import com.swifty.domain.CompilationUnit;

public class BytecodeGenerator {

    public byte[] generate(CompilationUnit compilationUnit) {
        ClassDeclaration classDeclaration = compilationUnit.classDeclaration();
        ClassGenerator classGenerator = new ClassGenerator();
        return classGenerator.generate(classDeclaration).toByteArray();
    }
}
