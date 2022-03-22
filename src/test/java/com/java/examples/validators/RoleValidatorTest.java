package com.java.examples.validators;

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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleValidatorTest {
    public static final int MINIMUM_SALARY = 5;
    public static final int MAXIMUM_SALARY = 10;
    public static final Role ROLE = Role.Executive;
    public static final String NAME = "Somebody";
    public static final String ID = "1";
    @Mock private Validator mockValidator1;
    @Mock private Validator mockValidator2;
    @InjectMocks private RoleValidator validator;

    @BeforeEach
    public void before() {
        ReflectionTestUtils.setField(validator, "validators", List.of(mockValidator1, mockValidator2));
    }

    @Test
    public void testValidate_NoMatch() {
        Associate associate = new Associate().setId(ID).setName(NAME).setRole(ROLE);
        when(mockValidator1.appliesTo(associate)).thenReturn(false);
        when(mockValidator2.appliesTo(associate)).thenReturn(false);
        validator.validate(associate);
        verify(mockValidator1, times(0)).validate(associate);
        verify(mockValidator2, times(0)).validate(associate);
    }

    @Test
    public void testValidate_SecondApplies() {
        Associate associate = new Associate().setId(ID).setName(NAME).setRole(ROLE);
        when(mockValidator1.appliesTo(associate)).thenReturn(false);
        when(mockValidator2.appliesTo(associate)).thenReturn(true);
        validator.validate(associate);
        verify(mockValidator1, times(0)).validate(associate);
        verify(mockValidator2).validate(associate);
    }

    @Test
    public void testBuild_ErrorOccurs() {
        Associate associate = new Associate().setId(ID).setName(NAME).setRole(ROLE);
        when(mockValidator1.appliesTo(associate)).thenReturn(true);
        doThrow(new InvalidRoleRuntimeException(ROLE, ID)).when(mockValidator1).validate(associate);
        assertThrows(InvalidRoleRuntimeException.class, () -> validator.validate(associate));
    }
}
