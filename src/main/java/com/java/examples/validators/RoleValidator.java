package com.java.examples.validators;

import com.java.examples.domain.Associate;
import com.java.examples.exceptions.InvalidRoleRuntimeException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RoleValidator {
    @Resource List<Validator> validators;

    public void validate(Associate associate) throws InvalidRoleRuntimeException {
        validators.forEach(validator -> {
            if (validator.appliesTo(associate)) {
                validator.validate(associate);
            }
        });
    }
}
