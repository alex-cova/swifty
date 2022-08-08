package com.swifty.domain;


import com.swifty.bytecodegeneration.MethodGenerator;
import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.type.Type;

import java.util.List;

/**
 * Created by Alex
 */
public class Function {

    private final FunctionSignature functionSignature;
    private final Statement rootStatement;

    public Function(FunctionSignature functionSignature, Statement rootStatement) {
        this.functionSignature = functionSignature;
        this.rootStatement = rootStatement;

        System.out.println(functionSignature.toString());
    }

    public String getName() {
        return functionSignature.name();
    }

    public List<Parameter> getParameters() {
        return functionSignature.parameters();
    }

    public Statement getRootStatement() {
        return rootStatement;
    }

    public Type getReturnType() {
        return functionSignature.returnType();
    }

    public void accept(MethodGenerator generator) {
        generator.generate(this);
    }
}
