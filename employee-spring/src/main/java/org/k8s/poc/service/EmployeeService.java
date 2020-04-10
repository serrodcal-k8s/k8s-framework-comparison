package org.k8s.poc.service;

import org.k8s.poc.domain.Employee;
import org.k8s.poc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Flux<Employee> getEmployees() { return employeeRepository.getEmployees(); }

    public Mono<Employee> getEmployee(Long id) { return employeeRepository.getEmployee(id); }

    public Mono<Response> createEmployee(Employee employee) { return employeeRepository.saveEmployee(employee); }

    public Mono<Response> updateEmployee(Employee employee) { return employeeRepository.updateEmployee(employee); }

    public Mono<Response> deleteEmployee(Long id) { return employeeRepository.deleteEmployee(id); }

}
