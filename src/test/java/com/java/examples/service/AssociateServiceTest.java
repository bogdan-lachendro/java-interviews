package com.java.examples.validators;

import com.java.examples.builders.AssociateBuilder;
import com.java.examples.domain.Associate;
import com.java.examples.domain.Role;
import com.java.examples.service.AssociateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssociateServiceTest {
    public static final int MINIMUM_SALARY = 5;
    public static final int MAXIMUM_SALARY = 10;
    public static final Role ROLE = Role.Executive;
    public static final String NAME = "Somebody";
    public static final String FIRST_ID = "1";
    public static final String SECOND_ID = "2";
    public static final String THIRD_ID = "3";
    public static final String FIRST_NAME = "First Associate";
    public static final String SECOND_NAME = "Second Associate";
    public static final String THIRD_NAME = "Third Associate";
    private Associate associate1 = new Associate().setId(FIRST_ID).setName(FIRST_NAME);
    private Associate associate2 = new Associate().setId(SECOND_ID).setName(SECOND_NAME);
    @Mock private AssociateBuilder builder;
    @InjectMocks private AssociateService service;

    @BeforeEach
    public void before() {
        Map<String, Associate> cache = new HashMap<>();
        cache.put(FIRST_ID, associate1);
        cache.put(SECOND_ID, associate2);
        ReflectionTestUtils.setField(service, "cache", cache);
    }

    @Test
    public void testGetAssociate() {
        assertEquals(associate1, service.getAssociate(FIRST_ID), "Associate is incorrect");
    }

    @Test
    public void testGetAssociates() {
        List<Associate> associates = service.getAssociates();
        assertTrue(associates.contains(associate1), "Associate1 does not exist in list");
        assertTrue(associates.contains(associate2), "Associate1 does not exist in list");
        assertEquals(2, associates.size(), "Associate size is incorrect");
    }

    @Test
    public void testAddAssociate() {
        Associate associate = new Associate().setId(THIRD_ID).setName(THIRD_NAME);
        Associate expectedAssociate = new Associate().setId(THIRD_ID).setName(THIRD_NAME).setMinimumSalary(1);
        when(builder.build(associate)).thenReturn(expectedAssociate);
        assertEquals(expectedAssociate, service.addAssociate(associate), "Associate returned was not correct");

        assertEquals(3, service.getAssociates().size(), "Associate size is incorrect");
    }
}
