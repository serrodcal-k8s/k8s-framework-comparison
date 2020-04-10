package org.k8s.poc.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.repository.EmployeeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public Multi<Employee> getEmployees() { return employeeRepository.getEmployees(); }

    public Uni<Employee> getEmployee(Long id) { return employeeRepository.getEmployee(id); }

    public Uni<Long> createEmployee(Employee employee) { return employeeRepository.saveEmployee(employee); }

    public Uni<Boolean> updateEmployee(Employee employee) { return employeeRepository.updateEmployee(employee); }

    public Uni<Boolean> deleteEmployee(Long id) { return employeeRepository.deleteEmployee(id); }
}
