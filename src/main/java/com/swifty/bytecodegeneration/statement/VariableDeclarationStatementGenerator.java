package com.swifty.bytecodegeneration.statement;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.Assignment;
import com.swifty.domain.node.statement.VariableDeclaration;

public class VariableDeclarationStatementGenerator {
    private final StatementGenerator statementGenerator;
    private final ExpressionGenerator expressionGenerator;

    public VariableDeclarationStatementGenerator(StatementGenerator statementGenerator, ExpressionGenerator expressionGenerator) {
        this.statementGenerator = statementGenerator;
        this.expressionGenerator = expressionGenerator;
    }

    public void generate(VariableDeclaration variableDeclaration) {
        Expression expression = variableDeclaration.expression();
        expression.accept(expressionGenerator);
        Assignment assignment = new Assignment(variableDeclaration);
        assignment.accept(statementGenerator);
    }
}
