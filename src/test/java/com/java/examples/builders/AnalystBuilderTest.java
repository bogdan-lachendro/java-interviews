package com.java.examples.builders;

import com.java.examples.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnalystBuilderTest {
    @InjectMocks private AnalystBuilder builder;

    @Test
    public void testRole() {
        assertEquals(Role.Analyst, builder.role(), "Role is incorrect");
    }

    @Test
    public void testMinimumSalary() {
        assertEquals(60000, builder.minimumSalary(), "Minimum Salary is incorrect");
    }

    @Test
    public void testMaximumSalary() {
        assertEquals(65000, builder.maximumSalary(), "Maximum Salary is incorrect");
    }
}
