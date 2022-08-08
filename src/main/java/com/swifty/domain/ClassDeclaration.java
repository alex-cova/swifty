package com.swifty.domain;

import com.swifty.domain.scope.Field;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex
 */
public record ClassDeclaration(String name, List<Field> fields, List<Function> methods) {

    @Override
    public List<Field> fields() {
        return Collections.unmodifiableList(fields);
    }

    @Override
    public List<Function> methods() {
        return Collections.unmodifiableList(methods);
    }

}
