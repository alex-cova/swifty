package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public interface Expression extends Statement {
    Type type();

    void accept(ExpressionGenerator generator);

    @Override
    void accept(StatementGenerator generator);
}
