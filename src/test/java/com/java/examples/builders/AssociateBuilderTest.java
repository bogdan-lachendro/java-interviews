package com.java.examples.builders;

import com.java.examples.domain.Associate;
import com.java.examples.domain.Role;
import com.java.examples.exceptions.InvalidRoleRuntimeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssociateBuilderTest {
    public static final int MINIMUM_SALARY = 5;
    public static final int MAXIMUM_SALARY = 10;
    public static final Role ROLE = Role.Executive;
    public static final String NAME = "Somebody";
    public static final String ID = "1";
    @Mock private Builder mockBuilder1;
    @Mock private Builder mockBuilder2;
    @InjectMocks private AssociateBuilder builder;

    @BeforeEach
    public void before() {
        ReflectionTestUtils.setField(builder, "builders", List.of(mockBuilder1, mockBuilder2));
    }

    @Test
    public void testBuild_NoneApplies() {
        assertThrows(InvalidRoleRuntimeException.class, () -> builder.build(new Associate().setId(ID).setName(NAME).setRole(ROLE)));
    }

    @Test
    public void testBuild_SecondApplies() {
        Associate associate = new Associate().setId(ID).setName(NAME).setRole(ROLE);
        Associate expectedAssociate = new Associate().setId(ID).setName(NAME).setRole(ROLE).setMaximumSalary(5);
        when(mockBuilder2.appliesTo(associate)).thenReturn(true);
        when(mockBuilder2.build(associate)).thenReturn(expectedAssociate);
        assertEquals(expectedAssociate, builder.build(associate));
    }
}
