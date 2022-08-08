package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.IfStatement;
import com.swifty.domain.node.statement.Statement;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class IfStatementVisitor extends SwiftyBaseVisitor<IfStatement> {
    private final StatementVisitor statementVisitor;
    private final ExpressionVisitor expressionVisitor;

    public IfStatementVisitor(StatementVisitor statementVisitor, ExpressionVisitor expressionVisitor) {
        this.statementVisitor = statementVisitor;
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public IfStatement visitIfStatement(@NotNull SwiftyParser.IfStatementContext ctx) {
        SwiftyParser.ExpressionContext conditionalExpressionContext = ctx.expression();
        Expression condition = conditionalExpressionContext.accept(expressionVisitor);
        Statement trueStatement = ctx.trueStatement.accept(statementVisitor);
        if (ctx.falseStatement != null) {
            Statement falseStatement = ctx.falseStatement.accept(statementVisitor);
            return new IfStatement(condition, trueStatement, falseStatement);
        }
        return new IfStatement(condition, trueStatement);
    }
}
