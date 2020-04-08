package org.k8s.poc.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReactiveEmployeeService {

    public Multi<Employee> getEmployees() {
        return Multi.createFrom()
                .items(new Employee(new Long(0), "Primero"), new Employee(new Long(1), "Segundo"));

    }

    public Uni<Employee> getEmployee(Long id) {
        return Uni.createFrom().item(new Employee(new Long(0), "Primero"));
    }


}
