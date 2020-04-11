package org.k8s.poc.resource;

import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @PostMapping(value= "/spring/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity> createEmployee(@RequestBody Employee employee) { return employeeService.createEmployee(employee); }

    @PutMapping("/spring/employee")
    public Mono<ResponseEntity> updateEmployee(@RequestBody Employee employee) { return employeeService.updateEmployee(employee); }

    @DeleteMapping("/spring/employee/{id}")
    public Mono<ResponseEntity> deleteEmployee(@PathVariable("id") Long id) { return employeeService.deleteEmployee(id); }

}
