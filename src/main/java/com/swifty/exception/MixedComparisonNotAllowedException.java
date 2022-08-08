package com.swifty.exception;

import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public class MixedComparisonNotAllowedException extends RuntimeException {
    public MixedComparisonNotAllowedException(Type leftType, Type rightType) {
        super("Comparison between object and primitive is not supported  :" + leftType + "  |  " + rightType);
    }
}
