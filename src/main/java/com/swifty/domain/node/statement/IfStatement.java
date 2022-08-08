package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Alex
 */
public class IfStatement implements Statement {


    private final Expression condition;
    private final Statement trueStatement;
    private final @Nullable Statement falseStatement;

    public IfStatement(Expression condition, Statement trueStatement, @Nullable Statement falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
    }

    public IfStatement(Expression condition, Statement trueStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = null;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getTrueStatement() {
        return trueStatement;
    }

    public @Nullable Statement getFalseStatement() {
        return falseStatement;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
