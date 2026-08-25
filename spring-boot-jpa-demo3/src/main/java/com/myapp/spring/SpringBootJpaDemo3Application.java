package com.myapp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.myapp.spring.repository.MovieJdbcRepository;

@SpringBootApplication()

public class SpringBootJpaDemo3Application implements ApplicationRunner {

	@Value("${example.message:None}")
	private  String messages;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Messages "+messages);
		
	}
	@Bean
	CommandLineRunner runner(){
		return args ->{
		System.out.println("Messages "+messages);
		};
	}

	public static void main(String[] args) {
	 ConfigurableApplicationContext context =	
	 SpringApplication.run(SpringBootJpaDemo3Application.class, args);
	
	 MovieJdbcRepository repository = 
	context.getBean(MovieJdbcRepository.class);	
	repository.findAll().forEach(System.out::println);
	//SpringBootJpaDemo3Application object = new SpringBootJpaDemo3Application();
	

	 //context.close();
	}

}
