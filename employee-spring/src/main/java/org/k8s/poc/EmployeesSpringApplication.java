package org.k8s.poc;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;

@SpringBootApplication
@EnableR2dbcRepositories
public class EmployeesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesSpringApplication.class, args);
	}

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

}
