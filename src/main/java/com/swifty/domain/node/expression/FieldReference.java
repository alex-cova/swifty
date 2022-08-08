package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.scope.Field;
import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public class FieldReference implements Reference {
    private final Field field;

    public FieldReference(Field field) {
        this.field = field;
    }


    @Override
    public String geName() {
        return field.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type type() {
        return field.getType();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public String getOwnerInternalName() {
        return field.getOwnerInternalName();
    }
}
