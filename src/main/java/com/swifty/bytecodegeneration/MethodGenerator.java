package com.swifty.bytecodegeneration;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.Constructor;
import com.swifty.domain.Function;
import com.swifty.domain.node.expression.EmptyExpression;
import com.swifty.domain.node.expression.SuperCall;
import com.swifty.domain.node.statement.Block;
import com.swifty.domain.node.statement.ReturnStatement;
import com.swifty.domain.node.statement.Statement;
import com.swifty.domain.scope.Scope;
import com.swifty.util.DescriptorFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class MethodGenerator {
    public static final String MAIN_FUN_NAME = "init";
    private final ClassWriter classWriter;

    public MethodGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    public void generate(Function function) {

        String description = DescriptorFactory.getMethodDescriptor(function);

        System.out.println("Function name: " + function.getName());


        Block block = (Block) function.getRootStatement();
        Scope scope = block.scope();

        int access = Opcodes.ACC_PUBLIC + (function.getName().equals(MAIN_FUN_NAME) ? Opcodes.ACC_STATIC : 0);
        MethodVisitor mv = classWriter.visitMethod(access, function.getName(), description, null, null);
        mv.visitCode();

        StatementGenerator statementScopeGenerator = new StatementGenerator(mv, scope);
        block.accept(statementScopeGenerator);

        appendReturnIfNotExists(function, block, statementScopeGenerator);

        mv.visitMaxs(-1, -1);
        mv.visitEnd();


    }

    public void generate(Constructor constructor) {
        Block block = (Block) constructor.getRootStatement();
        Scope scope = block.scope();


        String description = DescriptorFactory.getMethodDescriptor(constructor);
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", description, null, null);
        mv.visitCode();

        StatementGenerator statementScopeGenerator = new StatementGenerator(mv, scope);

        new SuperCall().accept(statementScopeGenerator);
        block.accept(statementScopeGenerator);

        appendReturnIfNotExists(constructor, block, statementScopeGenerator);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
    }

    private void appendReturnIfNotExists(Function function, Block block, StatementGenerator statementScopeGenrator) {
        boolean isLastStatementReturn = false;

        if (!block.statements().isEmpty()) {
            Statement lastStatement = block.statements().get(block.statements().size() - 1);
            isLastStatementReturn = lastStatement instanceof ReturnStatement;
        }

        if (!isLastStatementReturn) {
            EmptyExpression emptyExpression = new EmptyExpression(function.getReturnType());
            ReturnStatement returnStatement = new ReturnStatement(emptyExpression);
            returnStatement.accept(statementScopeGenrator);
        }
    }
}
