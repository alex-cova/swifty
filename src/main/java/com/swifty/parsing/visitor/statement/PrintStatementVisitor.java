package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.PrintStatement;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class PrintStatementVisitor extends SwiftyBaseVisitor<PrintStatement> {
    private final ExpressionVisitor expressionVisitor;

    public PrintStatementVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public PrintStatement visitPrintStatement(@NotNull SwiftyParser.PrintStatementContext ctx) {
        SwiftyParser.ExpressionContext expressionCtx = ctx.expression();
        Expression expression = expressionCtx.accept(expressionVisitor);
        return new PrintStatement(expression);
    }
}
