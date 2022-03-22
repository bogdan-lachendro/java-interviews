package com.java.examples.builders;

import com.java.examples.domain.Associate;
import com.java.examples.exceptions.InvalidRoleRuntimeException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AssociateBuilder {
    @Resource List<Builder> builders;

    public Associate build(Associate associate) {
        return builders.stream().filter(builder -> builder.appliesTo(associate)).findFirst().orElseThrow(() -> new InvalidRoleRuntimeException(associate.getRole(), associate.getId())).build(associate);
    }
}
