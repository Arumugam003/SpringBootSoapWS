package com.volley.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.volley.repo"})
@ComponentScan(value = "com.volley.*")
@EntityScan(basePackages = {"com.volley.model"} )
public class DataSourceSetup {
	
	@Value("$(spring.datasource.url)")
	String databaseUrl;
	
	@Value("$(spring.datasource.username)")
	String databaseUser;
	
	@Value("$(spring.datasource.password)")
	String databasePass;
	
	public DataSource dataSource() {
	
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setUrl(databaseUrl);
	dataSource.setUsername(databaseUser);
	dataSource.setPassword(databasePass);
	
	return dataSource;
	
	}
	

}
