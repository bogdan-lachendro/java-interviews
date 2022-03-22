package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class AnalystBuilder extends BaseBuilder {
    @Override
    public Role role() {
        return Role.Analyst;
    }

    @Override
    public int minimumSalary() {
        return 60000;
    }

    @Override
    public int maximumSalary() {
        return 65000;
    }
}
