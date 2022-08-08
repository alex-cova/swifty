package com.swifty.parsing;

import com.swifty.domain.CompilationUnit;
import com.swifty.parser.SwiftyLexer;
import com.swifty.parser.SwiftyParser;
import com.swifty.parsing.visitor.CompilationUnitVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by Alex
 */
public class Parser {

    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException {

        System.out.println("Compiling: " + fileAbsolutePath);

        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        SwiftyLexer lexer = new SwiftyLexer(charStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        SwiftyParser parser = new SwiftyParser(tokenStream);

        parser.addErrorListener(new SwiftyTreeWalkErrorListener());

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();

        return parser.compilationUnit().accept(compilationUnitVisitor);
    }

}
