package com.swifty.bytecodegeneration.statement;

import com.swifty.domain.node.statement.Block;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.Scope;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

public class BlockStatementGenerator {
    private final MethodVisitor methodVisitor;

    public BlockStatementGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(Block block) {
        Scope newScope = block.scope();
        List<Statement> statements = block.statements();
        StatementGenerator statementGenerator = new StatementGenerator(methodVisitor, newScope);
        statements.stream().forEach(stmt -> stmt.accept(statementGenerator));
    }
}
