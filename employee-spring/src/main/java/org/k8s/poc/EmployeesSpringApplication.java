package org.k8s.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class EmployeesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesSpringApplication.class, args);
	}

<<<<<<< HEAD

	
=======
	@Bean
  	public PostgresqlConnectionFactory connectionFactory() {
   		return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .username("spring_test")
                .password("spring_test")
                .database("spring_test")
                .build());
  	}

>>>>>>> e9f9d7e1928c184dbc366a5f35053133ae4e6b61


}
