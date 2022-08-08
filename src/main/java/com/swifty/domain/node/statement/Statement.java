package com.swifty.domain.node.statement;

import com.swifty.bytecodegeneration.statement.StatementGenerator;
import com.swifty.domain.node.Node;

/**
 * Created by Alex
 */
@FunctionalInterface
public interface Statement extends Node {
    void accept(StatementGenerator generator);
}
