package org.k8s.poc.service;

import org.k8s.poc.dao.EmployeeDao;
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

    public Flux<Employee> getEmployees() { return employeeRepository.findAll().map(e -> new Employee(e.getId(), e.getName())); }

    public Mono<Employee> getEmployee(Long id) { return employeeRepository.findById(id).map(e -> new Employee(e.getId(), e.getName()) ); }

    public Mono<Response> createEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setName(employee.name);
        return employeeRepository.save(employeeDao).map(null);
    }

    public Mono<Response> updateEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setId(employee.id);
        employeeDao.setName(employee.name);
        return employeeRepository.save(employeeDao).map(null);
    }

    public Mono<Response> deleteEmployee(Long id) { return employeeRepository.deleteById(id).map(null); }

}
