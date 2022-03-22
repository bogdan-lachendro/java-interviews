package com.java.examples.api;

import com.java.examples.domain.Associate;
import com.java.examples.exceptions.InvalidRoleRuntimeException;
import com.java.examples.service.AssociateService;
import com.java.examples.validators.RoleValidator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AssociateApi {
    private Map<String, Associate> associateCache = new HashMap<>();
    @Resource RoleValidator validator;
    @Resource AssociateService service;

    @GetMapping(value = "/api/getAssociate")
    public List<Associate> getAssociates() {
        return service.getAssociates();
    }

    @GetMapping(value = "/api/getAssociate/{id}")
    public Associate getAssociate(@PathVariable String id) {
        return service.getAssociate(id);
    }

    @PostMapping(value = "/api/associate")
    public Associate addAssociate(@RequestBody Associate associate) throws InvalidRoleRuntimeException {
        validator.validate(associate);
        return service.addAssociate(associate);
    }
}
