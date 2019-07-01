package com.vnext.interjava.userproduct.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableJpaRepositories(basePackages = {"com.vnext.interjava.userproduct.idea"})
@SpringBootApplication
@EnableTransactionManagement
public class IdeaApplication {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(IdeaApplication.class, args);


	}

	@Bean(name="dataSource")
	public DataSource getdataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
		driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
		driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));

		return driverManagerDataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(getdataSource());
	}



}
