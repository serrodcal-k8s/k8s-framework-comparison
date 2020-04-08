package org.k8s.poc.dao;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import org.k8s.poc.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class EmployeeDao {

    private Long id;

    private String name;

    public EmployeeDao() {
        // default constructor.
    }

    public EmployeeDao(String name) {
        this.name = name;
    }

    public EmployeeDao(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Multi<Employee> findAll(PgPool client) {
        return client.query("SELECT id, name FROM fruits ORDER BY name ASC")
                // Create a Multi from the set of rows:
                .onItem().produceMulti(set -> Multi.createFrom().items(() -> StreamSupport.stream(set.spliterator(), false)))
                // For each row create a fruit instance
                .onItem().apply(null);
    }

    public static Uni<Employee> findById(PgPool client, Long id) {
        return client.preparedQuery("SELECT id, name FROM fruits WHERE id = $1", Tuple.of(id))
                .onItem().apply(RowSet::iterator)
                .onItem().apply(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
    }

    public Uni<Long> save(PgPool client) {
        return client.preparedQuery("INSERT INTO fruits (name) VALUES ($1) RETURNING (id)", Tuple.of(name))
                .onItem().apply(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }

    public Uni<Boolean> update(PgPool client) {
        return client.preparedQuery("UPDATE fruits SET name = $1 WHERE id = $2", Tuple.of(name, id))
                .onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    public static Uni<Boolean> delete(PgPool client, Long id) {
        return client.preparedQuery("DELETE FROM fruits WHERE id = $1", Tuple.of(id))
                .onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    private static Employee from(Row row) {
        return new Employee(row.getLong("id"), row.getString("name"));
    }

}
