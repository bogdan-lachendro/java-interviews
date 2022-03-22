package com.java.examples.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Associate {
    private String id;
    private String name;
    private Role role;
    private int minimumSalary;
    private int maximumSalary;
}
