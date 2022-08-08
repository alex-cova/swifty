package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.Assignment;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class AssignmentStatementVisitor extends SwiftyBaseVisitor<Assignment> {
    private final ExpressionVisitor expressionVisitor;

    public AssignmentStatementVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Assignment visitAssignment(@NotNull SwiftyParser.AssignmentContext ctx) {
        SwiftyParser.ExpressionContext expressionCtx = ctx.expression();
        Expression expression = expressionCtx.accept(expressionVisitor);
        String varName = ctx.name().getText();
        return new Assignment(varName, expression);
    }
}
