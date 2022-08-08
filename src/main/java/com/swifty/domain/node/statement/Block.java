package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.scope.Scope;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex
 */
public record Block(Scope scope, List<Statement> statements) implements Statement {

    @Contract("_ -> new")
    public static @NotNull Block empty(Scope scope) {
        return new Block(scope, Collections.emptyList());
    }

    @Override
    public void accept(@NotNull StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public @NotNull @UnmodifiableView List<Statement> statements() {
        return Collections.unmodifiableList(statements);
    }
}
