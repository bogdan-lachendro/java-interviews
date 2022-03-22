package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class ExecutiveBuilder extends BaseBuilder {
    @Override
    public Role role() {
        return Role.Executive;
    }

    @Override
    public int minimumSalary() {
        return 90000;
    }

    @Override
    public int maximumSalary() {
        return 95000;
    }
}
