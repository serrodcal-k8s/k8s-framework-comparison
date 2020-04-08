package org.k8s.poc.domain;

public class Employee {

    private Long id;
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
