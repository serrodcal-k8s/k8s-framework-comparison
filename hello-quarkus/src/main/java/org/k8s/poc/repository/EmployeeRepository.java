package org.k8s.poc.repository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
public class EmployeeRepository {

    @Inject
    private EmployeeDao employeeDao;

    public Multi<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    public Uni<Employee> getEmployee(Long id) {
        return employeeDao.findById(id);
    }

    public Uni<Response> saveEmployee(Employee employee) {
        return employeeDao.save(employee.getName())
                .map(id -> Objects.nonNull(id) ? Response.Status.OK : Response.Status.NO_CONTENT)
                .map(status -> Response.status(status).build());
    }

    public Uni<Response> updateEmployee(Employee employee) {
        return employeeDao.update(employee.getId(), employee.getName())
                .map(updated -> updated ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }

    public Uni<Response> deleteEmployee(Long id) {
        return employeeDao.delete(id)
                .map(deleted -> deleted ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }
}
