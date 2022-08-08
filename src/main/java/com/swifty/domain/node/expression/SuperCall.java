package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex
 */
public class SuperCall implements Call {
    public static final String SUPER_IDETIFIER = "super";
    private final List<Argument> arguments;

    public SuperCall() {
        this(Collections.emptyList());
    }

    public SuperCall(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return SUPER_IDETIFIER;
    }

    @Override
    public Type type() {
        return BultInType.VOID;
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
