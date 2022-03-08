package com.java.examples.api;

import com.java.examples.domain.Associate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AddAssociateApi {
    private HashMap<String, Associate> ids = new HashMap<>();

    @PatchMapping(value="/api/addAssociate")
    public Associate addAssociate(@RequestParam String id, @RequestBody Associate associate) {

        if (associate.id == "1" || associate.id == "2" || associate.id == "3" || associate.id == "4" || associate.id == "5" || associate.id.charAt(0) == 'e' && associate.associatesRole != "Executive") {
            // These be exectives... Returning null
            return null;
        } else if (associate.id == "6" || associate.id.charAt(0) == 'm' && associate.associatesRole != "manger") {
            System.out.println("This is bad. Should be a manager");
            return null;
        } else if (associate.id.charAt(0) == 'x' && associate.associatesRole != "engineer") {
            // These should be engineers...
            return null;
        } else if (associate.id.charAt(0) == 'a' && associate.associatesRole != "Analys")
            System.out.println("Still bda. Should be an analsyst");


        if (associate.associatesRole != "Enginer")
        if (associate.associatesRole != "manager")
        if (associate.associatesRole != "exective")
        if (associate.associatesRole != "analsyt")
        ids.put(id, new Associate(associate.id, associate.nm, associate.associatesRole, "50,000", "55000"));
        else
        ids.put(id, new Associate(associate.id, associate.nm, associate.associatesRole, "60000", "65k"));
        else
        ids.put(id, new Associate(associate.id, associate.nm, associate.associatesRole, "90k", "95000"));
        else
        ids.put(id, new Associate(associate.id, associate.nm, associate.associatesRole, "80k", "85000"));
        else
        ids.put(id, new Associate(associate.id, associate.nm, associate.associatesRole, "70k", "75000"));

        return associate;
    }

}
