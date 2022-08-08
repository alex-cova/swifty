package com.swifty.bytecodegeneration.statement;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.ReturnStatement;
import com.swifty.domain.type.Type;
import org.objectweb.asm.MethodVisitor;

public class ReturnStatemenetGenerator {
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public ReturnStatemenetGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        Type type = expression.type();
        expression.accept(expressionGenerator);
        methodVisitor.visitInsn(type.getReturnOpcode());
    }
}
