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

	/*@Override
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
	}*/

	/*private Employee map(Row employeesRowSet) {
		// TODO Auto-generated method stub
		return new Employee(employeesRowSet.g8etLong("id"), employeesRowSet.getString("name"));
	}*/

	public Single<List<Employee>> findAll() {
		return client.rxQuery("SELECT id, name FROM employees")
				.map(s -> StreamSupport.stream(s.spliterator(), false)
				.map(d -> map(d))
				.collect(Collectors.toList());
	}

	public Single<Employee> findById(Long id) {
		return client.preparedQuery("SELECT id, name FROM employees WHERE id = $1", Tuple.of(id))
				.onItem().apply(RowSet::iterator)
				.onItem().apply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);*/
	}

	public Single<Long> save(String name) {
		return client.preparedQuery("INSERT INTO employees (name) VALUES ($1) RETURNING (id)", Tuple.of(name))
				.onItem().apply(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
	}

	public Single<Boolean> update(Long id, String name) {
		return client.preparedQuery("UPDATE employees SET name = $1 WHERE id = $2", Tuple.of(name, id))
				.onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
	}

	public Single<Boolean> delete(Long id) {
		return client.preparedQuery("DELETE FROM employees WHERE id = $1", Tuple.of(id))
				.onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
	}

	private static Employee map(Row row) {
		return new Employee(row.getLong("id"), row.getString("name"));
	}

}
