package com.swifty.exception;

import com.swifty.domain.node.expression.Parameter;

import java.util.List;

/**
 * Created by Alex
 */
public class ParameterForNameNotFoundException extends RuntimeException {
    public ParameterForNameNotFoundException(String name, List<Parameter> parameters) {
    }
}
