package com.swifty.domain.node.expression;


import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.type.Type;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Alex
 */
public class Argument implements Expression {

    private final @Nullable String parameterName;
    private final Expression expression;

    public Argument(Expression expression, @Nullable String parameterName) {
        this.parameterName = parameterName;
        this.expression = expression;
    }

    @Override
    public Type type() {
        return expression.type();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        expression.accept(generator);
    }

    @Override
    public void accept(StatementGenerator generator) {
        expression.accept(generator);
    }

    public @Nullable String getParameterName() {
        return parameterName;
    }
}
