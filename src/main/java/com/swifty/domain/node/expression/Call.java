package com.swifty.domain.node.expression;

import java.util.List;

/**
 * Created by Alex
 */
public interface Call extends Expression {
    List<Argument> getArguments();
    String getIdentifier();
}
