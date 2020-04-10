package org.k8s.poc.resource;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/quarkus/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    public Multi<Employee> getEmployees() { return employeeService.getEmployees(); }

    @GET
    @Path("{id}")
    public Uni<Employee> getEmployee(@PathParam("id") Long id) { return employeeService.getEmployee(id); }

    @POST
    public Uni<Response> createEmployee(Employee employee) {
        return employeeService.createEmployee(employee)
                .map(id -> Objects.nonNull(id) ? Response.Status.OK : Response.Status.NO_CONTENT)
                .map(status -> Response.status(status).build());
    }

    @PUT
    public Uni<Response> updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee)
                .map(updated -> updated ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }

    @DELETE
    @Path("{id}")
    public Uni<Response> deleteEmployee(@PathParam("id") Long id) {
        return employeeService.deleteEmployee(id)
                .map(deleted -> deleted ? Response.Status.OK : Response.Status.ACCEPTED)
                .map(status -> Response.status(status).build());
    }

}
