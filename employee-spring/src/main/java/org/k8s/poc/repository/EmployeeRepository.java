package org.k8s.poc.repository;

import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;

public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeDao, Long> {
}

/*@Repository
public class EmployeeRepository {

    public Flux<Employee> getEmployees() { return null; }

    public Mono<Employee> getEmployee(Long id) { return null; }

    public Mono<Response> saveEmployee(Employee employee) { return null; }

    public Mono<Response> updateEmployee(Employee employee) { return null; }

    public Mono<Response> deleteEmployee(Long id) { return null; }
}*/
