package com.swifty.domain.scope;

import com.swifty.domain.node.expression.Argument;
import com.swifty.domain.node.expression.Parameter;
import com.swifty.domain.type.Type;
import com.swifty.exception.ParameterForNameNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Created by Alex
 */
public record FunctionSignature(String name, List<Parameter> parameters, Type returnType) {

    @Override
    public List<Parameter> parameters() {
        return Collections.unmodifiableList(parameters);
    }

    public Parameter getParameterForName(String name) {
        return parameters.stream()
                .filter(param -> param.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new ParameterForNameNotFoundException(name, parameters));
    }

    public int getIndexOfParameter(String parameterName) {
        Parameter parameter = getParameterForName(parameterName);
        return parameters.indexOf(parameter);
    }

    public boolean matches(String otherSignatureName, List<Argument> arguments) {
        boolean namesAreEqual = this.name.equals(otherSignatureName);

        if (!namesAreEqual) return false;
        long nonDefaultParametersCount = parameters.stream()
                .filter(p -> p.defaultValue() == null)
                .count();

        if (nonDefaultParametersCount > arguments.size()) return false;

        boolean isNamedArgList = arguments.stream()
                .anyMatch(a -> a.getParameterName() != null);

        if (isNamedArgList) {
            return areArgumentsAndParamsMatchedByName(arguments);
        }
        return areArgumentsAndParamsMatchedByIndex(arguments);
    }

    private boolean areArgumentsAndParamsMatchedByIndex(@NotNull List<Argument> arguments) {
        return IntStream.range(0, arguments.size())
                .allMatch(i -> {
                    Type argumentType = arguments.get(i).type();
                    Type parameterType = parameters.get(i).type();
                    return argumentType.equals(parameterType);
                });
    }

    private boolean areArgumentsAndParamsMatchedByName(@NotNull List<Argument> arguments) {
        return arguments.stream().allMatch(a -> {
            String paramName = a.getParameterName();

            if (paramName == null) return false;

            return parameters.stream()
                    .map(Parameter::name)
                    .anyMatch(paramName::equals);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionSignature that = (FunctionSignature) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(parameters, that.parameters)) return false;

        return Objects.equals(returnType, that.returnType);

    }

    @Override
    public String toString() {
        return "FunctionSignature{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                ", returnType=" + returnType +
                '}';
    }
}
