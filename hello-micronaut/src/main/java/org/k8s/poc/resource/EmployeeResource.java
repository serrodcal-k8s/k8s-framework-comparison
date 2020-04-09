package org.k8s.poc.resource;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.EmployeeService;

import javax.inject.Inject;
import java.util.List;

@Controller("/micronaut/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@Inject
	private EmployeeService employeeService;

	@Get
	public Single<List<Employee>> getEmployees() { return employeeService.getEmployees(); }

	@Get
	//@Path("{id}")
	public Single<Employee> getEmployee(@PathParam("id") Long id) { return employeeService.getEmployee(id); }

	/*@Post
	public Single<Response> createEmployee(Employee employee) { return employeeService.createEmployee(employee); }

	@Put
	public Single<Response> updateEmployee(Employee employee) { return employeeService.updateEmployee(employee); }

	@Delete
	//@Path("{id}")
	public Single<Response> deleteEmployee(@PathParam("id") Long id) { return employeeService.deleteEmployee(id); }
	 */
}
