package com.swifty.bytecodegeneration.expression;

import com.swifty.domain.node.expression.FieldReference;
import com.swifty.domain.node.expression.LocalVariableReference;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ReferenceExpressionGenerator {
    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public ReferenceExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(LocalVariableReference localVariableReference) {
        String varName = localVariableReference.geName();
        int index = scope.getLocalVariableIndex(varName);
        Type type = localVariableReference.type();
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }

    public void generate(FieldReference fieldReference) {
        String varName = fieldReference.geName();
        Type type = fieldReference.type();
        String ownerInternalName = fieldReference.getOwnerInternalName();
        String descriptor = type.getDescriptor();
        methodVisitor.visitVarInsn(Opcodes.ALOAD,0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, ownerInternalName,varName,descriptor);
    }
}
