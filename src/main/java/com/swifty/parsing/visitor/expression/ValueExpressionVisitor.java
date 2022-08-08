package com.swifty.parsing.visitor.expression;

import com.swifty.domain.node.expression.Value;
import com.swifty.domain.type.Type;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.util.TypeResolver;
import org.jetbrains.annotations.NotNull;

public class ValueExpressionVisitor extends SwiftyBaseVisitor<Value> {

    @Override
    public Value visitValue(@NotNull SwiftyParser.ValueContext ctx) {
        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(ctx);
        return new Value(type, value);
    }
}
