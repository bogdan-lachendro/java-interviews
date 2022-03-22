package com.java.examples.builders;

import com.java.examples.domain.Associate;
import com.java.examples.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BaseBuilderTest {
    public static final int MINIMUM_SALARY = 5;
    public static final int MAXIMUM_SALARY = 10;
    public static final Role ROLE = Role.Executive;
    public static final String NAME = "Somebody";
    public static final String ID = "1";
    private BaseBuilder builder = new BaseBuilder() {
        @Override public Role role() {
            return ROLE;
        }

        @Override public int minimumSalary() {
            return MINIMUM_SALARY;
        }

        @Override public int maximumSalary() {
            return MAXIMUM_SALARY;
        }
    };

    @Test
    public void testBuild() {
        Associate expectedAssociate = new Associate().setId(ID).setName(NAME).setRole(ROLE)
                .setMinimumSalary(MINIMUM_SALARY).setMaximumSalary(MAXIMUM_SALARY);
        Associate associate = builder.build(new Associate().setId(ID).setName(NAME).setRole(ROLE));
        assertEquals(expectedAssociate, associate, "Associate is incorrectly built");
    }

    @Test
    public void testApplies() {
        assertTrue(builder.appliesTo(new Associate().setRole(ROLE)));
    }

    @Test
    public void testApplies_DoesNotApply() {
        assertFalse(builder.appliesTo(new Associate().setRole(Role.Manager)));
    }
}
