package org.k8s.poc.repository;

import org.k8s.poc.dao.EmployeeDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeDao, Long> {

}
