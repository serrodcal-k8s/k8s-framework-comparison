package org.k8s.poc.repository;

import io.reactivex.Single;
import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

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

    public Single<Response> saveEmployee(Employee employee) {
        return employeeDao.save(employee.name)
                .map(id -> Objects.nonNull(id) ? Response.Status.OK : Response.Status.NO_CONTENT)
                .map(status -> Response.status(status).build());
    }

    public Single<Response> updateEmployee(Employee employee) {
        return employeeDao.update(employee.id, employee.name)
                .map(updated -> updated ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }

    public Single<Response> deleteEmployee(Long id) {
        return employeeDao.delete(id)
                .map(deleted -> deleted ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }
}
