package com.swifty.exception;

import com.swifty.domain.scope.FunctionSignature;
import com.swifty.parser.SwiftyParser;

import java.util.List;

/**
 * Created by Alex
 */
public class BadArgumentsSize extends RuntimeException {
    public BadArgumentsSize(FunctionSignature function, List<SwiftyParser.ExpressionContext> calledParameters) {
        super("Bad arguments amount");
    }
}
