package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.Type;
import com.swifty.exception.UnsupportedRangedLoopTypes;
import com.swifty.util.TypeChecker;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Alex
 */
public class RangedForStatement implements Statement {

    private final Statement iteratorVariable;
    private final Expression startExpression;
    private final Expression endExpression;
    private final Statement statement;
    private final String iteratorVarName;
    private final Scope scope;

    public RangedForStatement(Statement iteratorVariable, @NotNull Expression startExpression,
                              @NotNull Expression endExpression, Statement statement,
                              String iteratorVarName, Scope scope) {
        this.scope = scope;

        Type startExpressionType = startExpression.type();
        Type endExpressionType = endExpression.type();

        boolean typesAreIntegers = TypeChecker.isInt(startExpressionType) || TypeChecker.isInt(endExpressionType);

        if (!typesAreIntegers) {
            throw new UnsupportedRangedLoopTypes(startExpression, endExpression);
        }
        this.iteratorVariable = iteratorVariable;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.statement = statement;
        this.iteratorVarName = iteratorVarName;
    }

    public Statement getIteratorVariableStatement() {
        return iteratorVariable;
    }

    public Expression getStartExpression() {
        return startExpression;
    }

    public Expression getEndExpression() {
        return endExpression;
    }

    public Statement getStatement() {
        return statement;
    }

    public String getIteratorVarName() {
        return iteratorVarName;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public Scope getScope() {
        return scope;
    }

    public Type getType() {
        return startExpression.type();
    }
}
