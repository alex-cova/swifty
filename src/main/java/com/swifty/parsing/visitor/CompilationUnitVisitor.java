package com.swifty.parsing.visitor;

import com.swifty.domain.ClassDeclaration;
import com.swifty.domain.CompilationUnit;
import com.swifty.parser.SwiftyBaseVisitor;
import com.swifty.parser.SwiftyParser;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Alex
 */
public class CompilationUnitVisitor extends SwiftyBaseVisitor<CompilationUnit> {

    @Override
    public CompilationUnit visitCompilationUnit(@NotNull SwiftyParser.CompilationUnitContext ctx) {
        ClassVisitor classVisitor = new ClassVisitor();
        SwiftyParser.ClassDeclarationContext classDeclarationContext = ctx.classDeclaration();
        ClassDeclaration classDeclaration = classDeclarationContext.accept(classVisitor);
        return new CompilationUnit(classDeclaration);
    }
}
