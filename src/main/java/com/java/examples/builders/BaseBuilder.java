package com.java.examples.builders;

import com.java.examples.domain.Associate;
import com.java.examples.domain.Role;

public abstract class BaseBuilder implements Builder {
    @Override
    public Associate build(Associate associate) {
        return new Associate()
                .setId(associate.getId())
                .setName(associate.getName())
                .setRole(associate.getRole())
                .setMinimumSalary(minimumSalary())
                .setMaximumSalary(maximumSalary());
    }

    @Override
    public boolean appliesTo(Associate associate) {
        return role().equals(associate.getRole());
    }

    public abstract Role role();

    public abstract int minimumSalary();

    public abstract int maximumSalary();
}
