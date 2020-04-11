package org.k8s.poc.resource;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.k8s.poc.domain.Employee;
import org.k8s.poc.service.EmployeeService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.reactivex.Single;

@Controller("/micronaut/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@Inject
	private EmployeeService employeeService;

	@Get
	public Single<List<Employee>> getEmployees() {
		return employeeService.getEmployees();
	}

	@Get(uri = "/{id}")
	public Single<Employee> getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}

	@Post
	public Single<HttpResponse<?>> createEmployee(Employee employee) {
		return employeeService.createEmployee(employee)
				.map(id -> Objects.nonNull(id) ? HttpResponse.ok() : HttpResponse.accepted());
	}

	@Put
	public Single<HttpResponse<?>> updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee)
				.map(updated -> updated ? HttpResponse.ok() : HttpResponse.accepted());
	}

	@Delete(uri = "{id}")
	public Single<HttpResponse<?>> deleteEmployee(Long id) {
		return employeeService.deleteEmployee(id)
				.map(deleted -> deleted ? HttpResponse.ok() : HttpResponse.accepted());
	}
}
