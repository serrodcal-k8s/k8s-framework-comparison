package org.k8s.poc.service;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.k8s.poc.dao.EmployeeDao;
import org.k8s.poc.domain.Employee;
import org.k8s.poc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.api.PostgresqlConnection;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Row;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeService {

	@Autowired
	private ConnectionFactory connectionFactory;

	private DatabaseClient client;
	@PostConstruct
	public void initDb() {
		client = DatabaseClient.create(connectionFactory);
		client.execute("CREATE TABLE if not exists employees (id SERIAL PRIMARY KEY, name TEXT NOT NULL)").fetch()
				.rowsUpdated().block();
		client.execute("insert into employees (name) values ('serrodcal')").fetch().rowsUpdated().block();
		client.execute("insert into employees (name) values ('lechowsky')").fetch().rowsUpdated().block();

	}

	@Autowired
	private EmployeeRepository employeeRepository;

	public Flux<Employee> getEmployees() {
		return client.execute("select * from employees").map(e -> map(e)).all();
	}

	private Employee map(Row e) {
		// TODO Auto-generated method stub
		return new Employee(Long.valueOf(String.valueOf(e.get("id"))),String.valueOf( e.get("name")));
	}

	public Mono<Employee> getEmployee(Long id) {
		return employeeRepository.findById(id).map(e -> new Employee(e.getId(), e.getName()));
	}

	public Mono<ResponseEntity> createEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.setName(employee.name);
		return employeeRepository.save(employeeDao).map(e -> Objects.nonNull(e) ? ResponseEntity.ok().build() : ResponseEntity.accepted().build());
	}

	public Mono<ResponseEntity> updateEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.setId(employee.id);
		employeeDao.setName(employee.name);
		return employeeRepository.save(employeeDao).map(e -> Objects.nonNull(e) ? ResponseEntity.ok().build() : ResponseEntity.accepted().build());
	}

	public Mono<ResponseEntity> deleteEmployee(Long id) {
		return employeeRepository.deleteById(id).map(e -> Objects.nonNull(e) ? ResponseEntity.ok().build() : ResponseEntity.accepted().build());
	}

}
