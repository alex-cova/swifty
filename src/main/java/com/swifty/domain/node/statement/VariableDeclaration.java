package com.swifty.domain.node.statement;


import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Alex
 */
public record VariableDeclaration(String name, Expression expression) implements Statement {

    @Override
    public void accept(@NotNull StatementGenerator generator) {
        generator.generate(this);
    }
}
