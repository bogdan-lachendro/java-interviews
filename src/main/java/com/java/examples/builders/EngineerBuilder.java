package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class EngineerBuilder extends BaseBuilder {
    @Override
    public Role role() {
        return Role.Engineer;
    }

    @Override
    public int minimumSalary() {
        return 70000;
    }

    @Override
    public int maximumSalary() {
        return 75000;
    }
}
