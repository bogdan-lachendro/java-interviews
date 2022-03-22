package com.java.examples.validators;

import com.java.examples.domain.Associate;
import com.java.examples.exceptions.InvalidRoleRuntimeException;

public interface Validator {
    void validate(Associate associate) throws InvalidRoleRuntimeException;
    boolean appliesTo(Associate associate);
}
