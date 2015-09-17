package com.indusmed.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.indusmed.dao.UserManagementDaoImpl;



@ComponentScan("com.indusmed")
@SpringBootApplication
public class ApplicationBootLoader extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationBootLoader.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootLoader.class, args);
	}
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/indusmed");
		dataSource.setUsername("root");
		dataSource.setPassword("sandy");
		return dataSource;
	}
	
	@Bean
	public UserManagementDaoImpl userManagementDao(){
		UserManagementDaoImpl dao = new UserManagementDaoImpl();
		dao.setDataSource(dataSource());		
		return dao;
	}
}
