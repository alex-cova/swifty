package com.swifty.util;

import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public final class TypeChecker {
    public static boolean isInt(Type type) {
        return type == BultInType.INT;
    }

    public static boolean isBool(Type type) {
        return type == BultInType.BOOLEAN;
    }

    public static boolean isFloat(Type type) {
        return type == BultInType.FLOAT;
    }

    public static boolean isDouble(Type type) {
        return type == BultInType.DOUBLE;
    }
}
