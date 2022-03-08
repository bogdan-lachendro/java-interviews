package com.java.examples.api;

import com.java.examples.domain.Associate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class GetAssociateApi {
    private HashMap<String, Associate> ids = new HashMap<>();

    public GetAssociateApi() {
        ids.put("1", new Associate("1", "Joe Smith", "manger", null, null));
    }

    @PostMapping(value="/api/getAssociate")
    public Associate getAssociate(@RequestParam String id) {
        return ids.get(id);

    }

    public List getAssociates() {
        return (List) ids.values();
    }

}
