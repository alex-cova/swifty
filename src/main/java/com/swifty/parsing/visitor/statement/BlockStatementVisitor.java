package com.swifty.parsing.visitor.statement;

import com.swifty.domain.node.statement.Block;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.Scope;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class BlockStatementVisitor extends SwiftyBaseVisitor<Block> {
    private final Scope scope;

    public BlockStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Block visitBlock(@NotNull SwiftyParser.BlockContext ctx) {
        List<SwiftyParser.StatementContext> blockstatementsCtx = ctx.statement();
        Scope newScope = new Scope(scope);
        StatementVisitor statementVisitor = new StatementVisitor(newScope);
        List<Statement> statements = blockstatementsCtx.stream()
                .map(smtt -> smtt.accept(statementVisitor)).collect(Collectors.toList());
        return new Block(newScope, statements);
    }
}
