package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.repository.MovieJdbcRepository;

//@SpringBootApplication
public class SpringJpaDemo2Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringJpaDemo2Application.class, args);

AbstractApplicationContext container = 
new AnnotationConfigApplicationContext(AppConfig.class);

MovieJdbcRepository repository = container.getBean(MovieJdbcRepository.class);
// repository.findAll().forEach(System.out::println);

repository.recommendations("Inception"). forEach(System.out::println);
container.close();

}

}
