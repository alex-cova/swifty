package com.swifty.domain.node.expression.arthimetic;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;

/**
 * Created by Alex
 */
public class Multiplication extends ArthimeticExpression {
    public Multiplication(Expression leftExpress, Expression rightExpress) {
        super(leftExpress,rightExpress);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
