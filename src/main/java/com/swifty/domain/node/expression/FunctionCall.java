package com.swifty.domain.node.expression;

import com.swifty.bytecodegeneration.expression.ExpressionGenerator;
import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.type.Type;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex
 */
public class FunctionCall implements Call {
    private final Expression owner;
    private final FunctionSignature signature;
    private final List<Argument> arguments;
    private final Type type;

    public FunctionCall(@NotNull FunctionSignature signature, List<Argument> arguments, Expression owner) {
        this.type = signature.returnType();
        this.signature = signature;
        this.arguments = arguments;
        this.owner = owner;
    }

    public FunctionCall(FunctionSignature signature, List<Argument> arguments, Type ownerType) {
        this(signature,arguments,new EmptyExpression(ownerType));
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return signature.name();
    }

    public Type getOwnerType() {
        return owner.type();
    }

    public Expression getOwner() {
        return owner;
    }

    public FunctionSignature getSignature() {
        return signature;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type type() {
        return type;
    }
}
