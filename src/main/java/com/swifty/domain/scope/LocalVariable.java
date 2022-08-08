package com.swifty.domain.scope;

import com.swifty.domain.type.Type;

/**
 * Created by Alex
 */
public class LocalVariable implements Variable {
    private final String name;
    private final Type type;

    public LocalVariable(String name, Type type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
