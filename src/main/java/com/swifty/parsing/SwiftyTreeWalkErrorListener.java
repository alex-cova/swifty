package com.swifty.parsing;

import com.swifty.util.FakeLogger;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Created by Alex
 */
public class SwiftyTreeWalkErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.out.println(offendingSymbol);
        String errorFormat = "Error at line %d,char %d :(. Details:%n%s";
        String errorMsg = String.format(errorFormat, line, charPositionInLine, msg);
        FakeLogger.error(errorMsg);
    }
}
