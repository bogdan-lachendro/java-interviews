package com.java.examples.validators;

import com.java.examples.domain.Associate;
import com.java.examples.domain.Role;
import com.java.examples.exceptions.InvalidRoleRuntimeException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ExecutiveValidator implements Validator {
    private final Role role = Role.Executive;
    private final List<String> validIds = Arrays.asList("1", "2", "3", "4", "5");

    @Override
    public void validate(Associate associate) throws InvalidRoleRuntimeException {
        if (Objects.isNull(associate.getId()) || (!validIds.contains(associate.getId()) && !associate.getId().startsWith(role.prefix)))
            throw new InvalidRoleRuntimeException(role, associate.getId());
    }

    @Override
    public boolean appliesTo(Associate associate) {
        return role.equals(associate.getRole());
    }
}
