package org.k8s.poc.service;

import org.k8s.poc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

}
