package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;

/**
 * Created by Alex
 */
public interface Reference extends Expression {
    String geName();

    @Override
    void accept(ExpressionGenerator generator);

    @Override
    void accept(StatementGenerator generator);
}
