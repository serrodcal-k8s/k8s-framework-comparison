package org.k8s.poc.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.repository.EmployeeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReactiveEmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public Multi<Employee> getEmployees() { return employeeRepository.getEmployees(); }

    public Uni<Employee> getEmployee(Long id) {
        return employeeRepository.getEmployee(id);
    }

    public Uni<Response> createEmployee(Employee employee) { return employeeRepository.saveEmployee(employee); }

    public Uni<Response> updateEmployee(Employee employee) { return employeeRepository.updateEmployee(employee); }

    public Uni<Response> deleteEmployee(Long id) { return employeeRepository.deleteEmployee(id); }
}
