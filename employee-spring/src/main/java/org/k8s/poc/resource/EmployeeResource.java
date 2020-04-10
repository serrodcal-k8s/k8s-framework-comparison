package org.k8s.poc.resource;

import org.k8s.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/spring/employee")
    public Flux<String> getEmployees() {
        return Flux.fromStream(Stream.of("Hola"));
    }

}
