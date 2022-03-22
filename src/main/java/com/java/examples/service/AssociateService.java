package com.java.examples.service;

import com.java.examples.builders.AssociateBuilder;
import com.java.examples.domain.Associate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AssociateService {
    private Map<String, Associate> cache = new HashMap<>();
    @Resource AssociateBuilder builder;

    public Associate getAssociate(String id) {
        return cache.get(id);
    }

    public List<Associate> getAssociates() {
        return new ArrayList<>(cache.values());
    }

    public Associate addAssociate(Associate associate) {
        Associate builtAssociate = builder.build(associate);
        cache.put(associate.getId(), builtAssociate);
        return builtAssociate;
    }
}
