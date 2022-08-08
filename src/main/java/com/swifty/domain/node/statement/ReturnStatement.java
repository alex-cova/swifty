package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;

/**
 * Created by Alex
 */
public class ReturnStatement implements Statement {

    private final Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public Expression getExpression() {
        return expression;
    }
}
