package org.k8s.poc.repository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeRepository {

    @Inject
    private EmployeeDao employeeDao;

    public Multi<Employee> getEmployees() {
        return employeeDao.findAll();
        //return Multi.createFrom()
        //        .items(new Employee(new Long(0), "Primero"), new Employee(new Long(1), "Segundo"));
    }

    public Uni<Employee> getEmployee(Long id) {
        return employeeDao.findById(id);
        //return Uni.createFrom().item(new Employee(new Long(0), "Primero"));
    }



}
