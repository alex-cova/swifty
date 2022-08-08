package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.type.ClassType;
import com.swifty.domain.type.Type;

import java.util.Collections;
import java.util.List;

public class ConstructorCall implements Call {
    private final List<Argument> arguments;
    private final Type type;
    private final String identifier;

    public ConstructorCall(String identifier) {
        this(identifier, Collections.emptyList());
    }

    public ConstructorCall(String className, List<Argument> arguments) {
        this.type = new ClassType(className);
        this.arguments = arguments;
        this.identifier = type.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public String toString() {
        return "ConstructorCall{" +
                "arguments=" + arguments +
                ", type=" + type +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
