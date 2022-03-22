package com.java.examples.api;

import com.java.examples.domain.Associate;
import com.java.examples.service.AssociateService;
import com.java.examples.validators.RoleValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssociateApiTest {
    public static final String ID = "1";
    public static final String SECOND_ID = "2";
    @Mock private RoleValidator validator;
    @Mock private AssociateService service;
    @InjectMocks private AssociateApi associateApi;

    @Test
    public void testGetAssociates() {
        Associate firstExpectedAssociate = new Associate().setId(ID);
        Associate secondExpectedAssociate = new Associate().setId(SECOND_ID);
        when(service.getAssociates()).thenReturn(Arrays.asList(firstExpectedAssociate, secondExpectedAssociate));
        List<Associate> associates = associateApi.getAssociates();
        assertEquals(firstExpectedAssociate, associates.get(0), "First Associate is incorrect");
        assertEquals(secondExpectedAssociate, associates.get(1), "Second Associate is incorrect");
        assertEquals(2, associates.size(), "Associate size is incorrect");
    }

    @Test
    public void testGetAssociate() {
        Associate expectedAssociate = new Associate().setId(ID);
        when(service.getAssociate(ID)).thenReturn(expectedAssociate);
        Associate associate = associateApi.getAssociate(ID);
        assertEquals(expectedAssociate, associate, "Associate is incorrect");
    }

    @Test
    public void testAddAssociate() {
        Associate introAssociate = new Associate().setId(ID);
        Associate expectedAssociate = new Associate().setId(ID).setName("Somebody");
        when(service.addAssociate(introAssociate)).thenReturn(expectedAssociate);
        Associate associate = associateApi.addAssociate(introAssociate);
        verify(validator).validate(introAssociate);
        assertEquals(expectedAssociate, associate, "Associate is incorrect");
    }

}
