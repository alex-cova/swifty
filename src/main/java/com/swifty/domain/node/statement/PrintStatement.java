package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;

/**
 * Created by Alex
 */
public record PrintStatement(Expression expression) implements Statement {


    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
