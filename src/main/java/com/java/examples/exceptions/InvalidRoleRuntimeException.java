package com.java.examples.exceptions;

import com.java.examples.domain.Role;

public class InvalidRoleRuntimeException extends RuntimeException {
    public InvalidRoleRuntimeException(Role role, String id) {
        super(String.format("%s role is invalid with an id of %s", role.name(), id));
    }
}
