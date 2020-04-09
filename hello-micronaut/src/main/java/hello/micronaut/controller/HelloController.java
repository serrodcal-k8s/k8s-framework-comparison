package hello.micronaut.controller;

import hello.micronaut.dao.Employee;
import hello.micronaut.dao.EmployeeDao;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

@Controller("/hello")
public class HelloController {

	@Inject
	private EmployeeDao employeeDao;
	@Get
	public Single<List<Employee>> getEmployee() {
		return employeeDao.find(1L);
	}
}
