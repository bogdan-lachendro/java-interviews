package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExecutiveBuilderTest {
    @InjectMocks private ExecutiveBuilder builder;

    @Test
    public void testRole() {
        Assertions.assertEquals(Role.Executive, builder.role(), "Role is incorrect");
    }

    @Test
    public void testMinimumSalary() {
        Assertions.assertEquals(90000, builder.minimumSalary(), "Minimum Salary is incorrect");
    }

    @Test
    public void testMaximumSalary() {
        Assertions.assertEquals(95000, builder.maximumSalary(), "Maximum Salary is incorrect");
    }
}
