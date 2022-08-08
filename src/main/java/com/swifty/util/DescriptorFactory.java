package com.swifty.util;

import com.swifty.domain.Function;
import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.scope.FunctionSignature;
import com.swifty.domain.type.Type;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Alex
 */

//According to https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3
public final class DescriptorFactory {

    public static String getMethodDescriptor(Function function) {
        Collection<Parameter> parameters = function.getParameters();
        Type returnType = function.getReturnType();
        return getMethodDescriptor(parameters, returnType);
    }

    public static String getMethodDescriptor(FunctionSignature signature) {
        Collection<Parameter> parameters = signature.parameters();
        Type returnType = signature.returnType();
        return getMethodDescriptor(parameters, returnType);
    }

    private static String getMethodDescriptor(Collection<Parameter> parameters, Type returnType) {
        String parametersDescriptor = parameters.stream()
                .map(parameter -> parameter.type().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnDescriptor = returnType.getDescriptor();
        return parametersDescriptor + returnDescriptor;
    }
}
