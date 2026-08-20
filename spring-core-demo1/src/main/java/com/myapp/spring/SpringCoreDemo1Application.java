package com.myapp.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringCoreDemo1Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringCoreDemo1Application.class, args);

ApplicationContext container = new AnnotationConfigApplicationContext();

	}

}
