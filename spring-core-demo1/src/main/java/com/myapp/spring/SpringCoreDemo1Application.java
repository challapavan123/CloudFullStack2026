package com.myapp.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.service.MovieSearchService;

//@SpringBootApplication
public class SpringCoreDemo1Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringCoreDemo1Application.class, args);

ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
MovieSearchService searchService =  container.getBean(MovieSearchService.class);
searchService.search("The Matrix").forEach(System.out::println);

	}

}
