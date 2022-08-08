package com.swifty.bytecodegeneration.expression;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.expression.arthimetic.*;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ArithmeticExpressionGenerator {
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public ArithmeticExpressionGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(Addition expression) {
        if (expression.type().equals(BultInType.STRING)) {
            generateStringAppend(expression);
            return;
        }
        evaluateArithmeticComponents(expression);
        Type type = expression.type();
        methodVisitor.visitInsn(type.getAddOpcode());
    }

    public void generate(Substraction expression) {
        Type type = expression.type();
        evaluateArithmeticComponents(expression);
        methodVisitor.visitInsn(type.getSubstractOpcode());
    }

    public void generate(Multiplication expression) {
        evaluateArithmeticComponents(expression);
        Type type = expression.type();
        methodVisitor.visitInsn(type.getMultiplyOpcode());
    }

    public void generate(Division expression) {
        evaluateArithmeticComponents(expression);
        Type type = expression.type();
        methodVisitor.visitInsn(type.getDividOpcode());
    }

    private void evaluateArithmeticComponents(ArthimeticExpression expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        leftExpression.accept(expressionGenerator);
        rightExpression.accept(expressionGenerator);
    }

    private void generateStringAppend(Addition expression) {
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor.visitInsn(Opcodes.DUP);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        Expression leftExpression = expression.getLeftExpression();
        leftExpression.accept(expressionGenerator);
        String leftExprDescriptor = leftExpression.type().getDescriptor();
        String descriptor = "(" + leftExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor, false);
        Expression rightExpression = expression.getRightExpression();
        rightExpression.accept(expressionGenerator);
        String rightExprDescriptor = rightExpression.type().getDescriptor();
        descriptor = "(" + rightExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor, false);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
    }
}
