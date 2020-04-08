package org.k8s.poc.resource;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.ReactiveEmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quarkus/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    ReactiveEmployeeService service;


    @GET
    public Multi<Employee> getEmployees() { return service.getEmployees(); }

    @GET
    @Path("{id}")
    public Uni<Employee> getEmployee(@PathParam("id") Long id) { return service.getEmployee(id); }

    @POST
    public Uni<Response> createEmployee(Employee employee) { return null; }

    @PUT
    @Path("{id}")
    public Uni<Response> updateEmployee(@PathParam("id") Long id, Employee employee) { return null; }

    @DELETE
    @Path("{id}")
    public Uni<Response> deleteEmployee(@PathParam("id") Long id) { return null; }

}
