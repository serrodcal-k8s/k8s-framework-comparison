package org.k8s.poc.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@RestController
public class EmployeeResource {

    @GetMapping("/spring/employee")
    public Flux<String> getEmployees() {
        return Flux.fromStream(Stream.of("Hola"));
    }

}
