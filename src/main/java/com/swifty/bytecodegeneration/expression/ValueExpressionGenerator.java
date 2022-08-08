package com.swifty.bytecodegeneration.expression;

import com.swifty.domain.node.expression.Value;
import com.swifty.domain.type.Type;
import com.swifty.util.TypeResolver;
import org.objectweb.asm.MethodVisitor;

public class ValueExpressionGenerator {
    private final MethodVisitor methodVisitor;

    public ValueExpressionGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(Value value) {
        Type type = value.type();
        String stringValue = value.getValue();
        Object transformedValue = TypeResolver.getValueFromString(stringValue, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }
}
