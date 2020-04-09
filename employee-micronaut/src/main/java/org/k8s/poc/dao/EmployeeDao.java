package org.k8s.poc.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.vertx.reactivex.pgclient.PgPool;
import io.vertx.reactivex.sqlclient.Row;
import io.vertx.reactivex.sqlclient.RowSet;
import io.vertx.reactivex.sqlclient.Tuple;

import org.k8s.poc.domain.Employee;

@Singleton
public class EmployeeDao {

	@Inject
	private PgPool client;

	@PostConstruct
	public void initDb(){
		client.rxQuery("DROP TABLE IF EXISTS employees").blockingGet();
		client.rxQuery("CREATE TABLE employees (id SERIAL PRIMARY KEY, name TEXT NOT NULL)").blockingGet();
		client.rxQuery("INSERT INTO employees (name) VALUES ('Lechowsky')").blockingGet();
		client.rxQuery("INSERT INTO employees (name) VALUES ('Serrodcal')").blockingGet();
	}

	

	public Single<List<Employee>> findAll() {
		return client.rxQuery("select * from employees")
				.map(s ->
						StreamSupport.stream(s.spliterator(), false)
								.map(d -> map(d))
								.collect(Collectors.toList()));
	}

	public Single<Employee> findById(Long id) {
		return client.rxPreparedQuery("SELECT id, name FROM employees WHERE id = $1", Tuple.of(id))
				.map(RowSet::iterator)
				.map((iterator -> iterator.hasNext() ? map(iterator.next()) : null));
	
	}

	public Single<Long> save(String name) {
		return client.rxPreparedQuery("INSERT INTO employees (name) VALUES ($1) RETURNING (id)", Tuple.of(name))
				.map(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
	}

	public Single<Boolean> update(Long id, String name) {
		return client.rxPreparedQuery("UPDATE employees SET name = $1 WHERE id = $2", Tuple.of(name, id))
				.map(pgRowSet -> pgRowSet.rowCount() == 1);
	}

	public Single<Boolean> delete(Long id) {
		return client.rxPreparedQuery("DELETE FROM employees WHERE id = $1", Tuple.of(id))
				.map(pgRowSet -> pgRowSet.rowCount() == 1);
	}

	private static Employee map(Row row) {
		return new Employee(row.getLong("id"), row.getString("name"));
	}

}
