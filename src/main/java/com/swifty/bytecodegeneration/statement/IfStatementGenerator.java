package com.swifty.bytecodegeneration.statement;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.domain.node.statement.IfStatement;
import com.swifty.domain.node.statement.Statement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class IfStatementGenerator {
    private final StatementGenerator statementGenerator;
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public IfStatementGenerator(StatementGenerator statementGenerator, ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.statementGenerator = statementGenerator;
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(@NotNull IfStatement ifStatement) {
        ifStatement.getCondition()
                .accept(expressionGenerator);

        var trueLabel = new Label();
        var endLabel = new Label();

        methodVisitor.visitJumpInsn(Opcodes.IFNE, trueLabel);

        @Nullable Statement falseStatement = ifStatement.getFalseStatement();

        if (falseStatement != null) {
            falseStatement.accept(statementGenerator);
        }

        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(trueLabel);

        ifStatement.getTrueStatement()
                .accept(statementGenerator);

        methodVisitor.visitLabel(endLabel);
    }
}
