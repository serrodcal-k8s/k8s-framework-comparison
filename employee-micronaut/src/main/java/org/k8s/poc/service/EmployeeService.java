package org.k8s.poc.service;

import io.reactivex.Single;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public Single<List<Employee>> getEmployees() { return employeeRepository.getEmployees(); }

    public Single<Employee> getEmployee(Long id) {
        return employeeRepository.getEmployee(id);
    }

    public Single<Long> createEmployee(Employee employee) { return employeeRepository.saveEmployee(employee); }

    public Single<Boolean> updateEmployee(Employee employee) { return employeeRepository.updateEmployee(employee); }

    public Single<Boolean> deleteEmployee(Long id) { return employeeRepository.deleteEmployee(id); }

}
