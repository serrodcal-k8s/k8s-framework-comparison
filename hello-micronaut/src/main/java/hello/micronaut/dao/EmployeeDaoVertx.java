package hello.micronaut.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import io.reactivex.Single;
import io.vertx.reactivex.pgclient.PgPool;
import io.vertx.reactivex.sqlclient.Row;

public class EmployeeDaoVertx implements EmployeeDao {

	@Inject
	private PgPool client;

	@Override
	public Single<List<Employee>> find(long id) {
		client.rxQuery("DROP TABLE IF EXISTS employees").blockingGet();
		client.rxQuery("CREATE TABLE employees (id SERIAL PRIMARY KEY, name TEXT NOT NULL)").blockingGet();
		client.rxQuery("INSERT INTO employees (name) VALUES ('Lechowsky')").blockingGet();
		client.rxQuery("INSERT INTO employees (name) VALUES ('Serrodcal')").blockingGet();
		 return client.rxQuery("select * from employees")
				.map(s ->
						StreamSupport.stream(s.spliterator(), false)
								.map(d -> map(d))
								.collect(Collectors.toList()));
	}

	private Employee map(Row employeesRowSet) {
		// TODO Auto-generated method stub
		return new Employee(employeesRowSet.g8etLong("id"), employeesRowSet.getString("name"));
	}

}
