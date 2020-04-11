package org.k8s.poc.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public class EmployeeDao {

	@Id
    private Long id;
    private String name;

    public EmployeeDao() {}

    public EmployeeDao(String name) {
        this.name = name;
    }

    public EmployeeDao(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
