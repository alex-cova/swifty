package com.swifty.parsing.visitor.expression.function;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.type.Type;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import com.swifty.util.TypeResolver;
import org.jetbrains.annotations.NotNull;

public class ParameterExpressionVisitor extends SwiftyBaseVisitor<Parameter> {

    private final ExpressionVisitor expressionVisitor;

    public ParameterExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Parameter visitParameter(@NotNull SwiftyParser.ParameterContext ctx) {
        String name = ctx.ID().getText();
        Type type = TypeResolver.getFromTypeContext(ctx.type());
        return new Parameter(name, type, null);
    }

    @Override
    public Parameter visitParameterWithDefaultValue(@NotNull SwiftyParser.ParameterWithDefaultValueContext ctx) {
        String name = ctx.ID().getText();
        Type type = TypeResolver.getFromTypeContext(ctx.type());
        Expression defaultValue = ctx.defaultValue.accept(expressionVisitor);
        return new Parameter(name, type, defaultValue);
    }
}
