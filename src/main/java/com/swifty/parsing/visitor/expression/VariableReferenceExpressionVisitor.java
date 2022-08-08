package com.swifty.parsing.visitor.expression;

import com.swifty.domain.node.expression.FieldReference;
import com.swifty.domain.node.expression.LocalVariableReference;
import com.swifty.domain.node.expression.Reference;
import com.swifty.domain.scope.Field;
import com.swifty.domain.scope.LocalVariable;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;

public class VariableReferenceExpressionVisitor extends SwiftyBaseVisitor<Reference> {
    private final Scope scope;

    public VariableReferenceExpressionVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Reference visitVarReference(@NotNull SwiftyParser.VarReferenceContext ctx) {
        String varName = ctx.getText();
        if(scope.isFieldExists(varName)) {
            Field field = scope.getField(varName);
            return new FieldReference(field);
        }
        LocalVariable variable = scope.getLocalVariable(varName);
        return new LocalVariableReference(variable);
    }
}
