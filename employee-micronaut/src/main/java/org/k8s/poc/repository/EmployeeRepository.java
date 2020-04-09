package org.k8s.poc.repository;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;

import io.micronaut.http.HttpResponse;
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

    public Single<HttpResponse<?>> saveEmployee(Employee employee) {
        return employeeDao.save(employee.name)
                .map(id -> Objects.nonNull(id) ? HttpResponse.ok() : HttpResponse.accepted());
    }

    public Single<HttpResponse<?>> updateEmployee(Employee employee) {
        return employeeDao.update(employee.id, employee.name)
                .map(updated -> updated ? HttpResponse.ok() : HttpResponse.accepted());
    }

    public Single<HttpResponse<?>> deleteEmployee(Long id) {
        return employeeDao.delete(id)
                .map(deleted -> deleted ? HttpResponse.ok() : HttpResponse.accepted());
    }
}
