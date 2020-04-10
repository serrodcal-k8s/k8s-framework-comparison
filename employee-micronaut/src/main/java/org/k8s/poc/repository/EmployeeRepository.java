package org.k8s.poc.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;

import io.reactivex.Single;

@Singleton
public class EmployeeRepository {

    @Inject
    private EmployeeDao employeeDao;

    public Single<List<Employee>> getEmployees() {
        return employeeDao.findAll();
    }

    public Single<Employee> getEmployee(Long id) {
        return employeeDao.findById(id);
    }

    public Single<Long> saveEmployee(Employee employee) {
        return employeeDao.save(employee.name);
    }

    public Single<Boolean> updateEmployee(Employee employee) {
        return employeeDao.update(employee.id, employee.name);
    }

    public Single<Boolean> deleteEmployee(Long id) {
        return employeeDao.delete(id);
    }
}
