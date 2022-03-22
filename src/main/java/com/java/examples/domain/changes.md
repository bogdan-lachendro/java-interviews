# What changed in domain

* Added Role enumeration for all references to the role
* Renamed nm to name as spelling out names is better practice
* Renamed associatesRole to role as this is in the associate class and follows KISS rule
* Renamed leastSalary to minimumSalary as more consistent with how folks talk about salary ranges
* Renamed mostSalary to maximumSalary as more consistent with how folks talk about salary ranges
* Changed minimumSalary and maximumSalary to integers rather than strings
* Changed id, name and role to private vs public as they should be accessed through getters/setters
* Added @Data from lombok to add getters and setters along with toString/equals/hashcode
* Added @Accessors(chain=true) from lombok to make setters fluent style
* Changed Associate constructor associate to same names as those they are setting
* Changed Associate constructor to use pattern of `this.<variable> = <variable>;`
* Changed role type to Role
