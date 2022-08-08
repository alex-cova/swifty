package com.swifty.parsing.visitor.expression.function;

import com.swifty.domain.node.expression.Argument;
import com.swifty.domain.node.expression.Expression;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class ArgumentExpressionVisitor extends SwiftyBaseVisitor<Argument> {

    private final ExpressionVisitor expressionVisitor;

    public ArgumentExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Argument visitArgument(@NotNull SwiftyParser.ArgumentContext ctx) {
        Expression value = ctx.expression().accept(expressionVisitor);
        return new Argument(value, null);
    }

    @Override
    public Argument visitNamedArgument(@NotNull SwiftyParser.NamedArgumentContext ctx) {
        return new Argument(ctx.expression().accept(expressionVisitor), ctx.name().getText());
    }

}
