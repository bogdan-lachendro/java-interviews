package com.java.examples.domain;

public class Associate {
    public String id;
    public String nm;
    public String associatesRole;
    private String leastSalary;
    private String mostSalary;

    public Associate() {
    }

    public Associate(String theId, String theName, String role, String leastSalary, String mostSalary) {
        id = theId;
        nm = theName;
        role = role;
        leastSalary = leastSalary;
        mostSalary = mostSalary;
    }

    @Override
    public String toString() {
        return "Associate{" +
                "id='" + id + '\'' +
                ", nm='" + nm + '\'' +
                ", associatesRole='" + associatesRole + '\'' +
                ", leastSalary='" + leastSalary + '\'' +
                ", mostSalary='" + mostSalary + '\'' +
                '}';
    }
}
