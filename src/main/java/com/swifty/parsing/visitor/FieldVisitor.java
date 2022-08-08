package com.swifty.parsing.visitor;

import com.swifty.domain.scope.Field;
import com.swifty.domain.scope.Scope;
import com.swifty.domain.type.Type;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.util.TypeResolver;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Alex
 */
public class FieldVisitor extends SwiftyBaseVisitor<Field> {

    private final Scope scope;

    public FieldVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Field visitField(@NotNull SwiftyParser.FieldContext ctx) {
        Type owner = scope.getClassType();
        Type type = TypeResolver.getFromTypeContext(ctx.type());
        String name = ctx.name().getText();
        return new Field(name, owner, type);
    }
}
