package hello.micronaut.dao;

import io.reactivex.Single;

import java.util.List;

public interface EmployeeDao {

	
	Single<List<Employee>> find(long id);
}
