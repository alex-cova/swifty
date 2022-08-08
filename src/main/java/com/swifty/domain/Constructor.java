package com.swifty.domain;

import com.swifty.bytecodegeneration.MethodGenerator;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public class Constructor extends Function {
    public Constructor(FunctionSignature signature, Statement block) {
        super(signature, block);
    }

    @Override
    public Type getReturnType() {
        return BultInType.VOID;
    }

    @Override
    public void accept(MethodGenerator generator) {
        generator.generate(this);
    }
}
