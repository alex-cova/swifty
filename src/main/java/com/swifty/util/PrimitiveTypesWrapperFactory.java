package com.swifty.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.swifty.domain.type.BultInType;
import com.swifty.domain.type.ClassType;
import com.swifty.domain.type.Type;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Alex
 */
public class PrimitiveTypesWrapperFactory {

    private final static BiMap<BultInType,ClassType> types = ImmutableBiMap.of(
            BultInType.INT,ClassType.Integer(),
            BultInType.BOOLEAN,ClassType.Boolean(),
            BultInType.FLOAT,ClassType.Float(),
            BultInType.DOUBLE,ClassType.Double()
    );

    private final static Map<Type,String> toPrimitiveMethodName = ImmutableMap.of(
            ClassType.Integer(),"intValue"
    );

    public static Optional<BultInType> getPrimitiveForWrapper(Type type) {
        return Optional.ofNullable(types.inverse().get(type));
    }

    public static Optional<ClassType> getWrapperForPrimitive(Type type) {
        return Optional.ofNullable(types.get(type));
    }

}
