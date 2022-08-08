package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.expression.Expression;
import com.swifty.domain.node.statement.Assignment;
import com.swifty.domain.node.statement.RangedForStatement;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.node.statement.VariableDeclaration;
import com.swifty.domain.scope.LocalVariable;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.expression.ExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public class ForStatementVisitor extends SwiftyBaseVisitor<RangedForStatement> {
    private final Scope scope;
    private final ExpressionVisitor expressionVisitor;

    public ForStatementVisitor(Scope scope) {
        this.scope = scope;
        expressionVisitor = new ExpressionVisitor(this.scope);
    }

    @Override
    public RangedForStatement visitForStatement(@NotNull SwiftyParser.ForStatementContext ctx) {
        Scope newScope = new Scope(scope);
        SwiftyParser.ForConditionsContext forExpressionContext = ctx.forConditions();
        Expression startExpression = forExpressionContext.startExpr.accept(expressionVisitor);
        Expression endExpression = forExpressionContext.endExpr.accept(expressionVisitor);
        SwiftyParser.VariableReferenceContext iterator = forExpressionContext.iterator;
        StatementVisitor statementVisitor = new StatementVisitor(newScope);
        String varName = iterator.getText();
        if(newScope.isLocalVariableExists(varName)) {
            Statement iteratorVariable = new Assignment(varName, startExpression);
            Statement statement = ctx.statement().accept(statementVisitor);
            return new RangedForStatement(iteratorVariable, startExpression, endExpression,statement, varName, newScope);
        } else {
            newScope.addLocalVariable(new LocalVariable(varName,startExpression.type()));
            Statement iteratorVariable = new VariableDeclaration(varName,startExpression);
            Statement statement = ctx.statement().accept(statementVisitor);
            return new RangedForStatement(iteratorVariable, startExpression, endExpression,statement, varName,newScope);
        }
    }

}
