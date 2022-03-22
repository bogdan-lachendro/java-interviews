package com.java.examples.domain;

public enum Role {
    Analyst("a"), Engineer("x"), Manager("m"), Executive("e"), Other("--");

    public final String prefix;

    Role(String prefix) {
        this.prefix = prefix;
    }
}
