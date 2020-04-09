package org.k8s.poc.domain;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Employee {

    public Long id;
    public String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
