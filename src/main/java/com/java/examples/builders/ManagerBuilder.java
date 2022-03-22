package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class ManagerBuilder extends BaseBuilder {
    @Override
    public Role role() {
        return Role.Manager;
    }

    @Override
    public int minimumSalary() {
        return 80000;
    }

    @Override
    public int maximumSalary() {
        return 85000;
    }
}
