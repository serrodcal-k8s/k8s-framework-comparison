package org.k8s.poc.resource;

import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;
import java.util.stream.Stream;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/spring/employee")
    public Flux<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/spring/employee/{id}")
    public Mono<Employee> getEmployee(@PathVariable("id") Long id) { return employeeService.getEmployee(id); }

    @PostMapping("/spring/employee")
    public Mono<Response> createEmployee(Employee employee) { return employeeService.createEmployee(employee); }

    @PutMapping("/spring/employee")
    public Mono<Response> updateEmployee(Employee employee) { return employeeService.updateEmployee(employee); }

    @DeleteMapping("/spring/employee/{id}")
    public Mono<Response> deleteEmployee(@PathVariable("id") Long id) { return employeeService.deleteEmployee(id); }

}
