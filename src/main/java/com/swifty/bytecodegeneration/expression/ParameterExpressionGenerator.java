package com.swifty.bytecodegeneration.expression;

import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.Type;
import org.objectweb.asm.MethodVisitor;

public class ParameterExpressionGenerator {
    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public ParameterExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(Parameter parameter) {
        Type type = parameter.type();
        int index = scope.getLocalVariableIndex(parameter.name());
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }
}
