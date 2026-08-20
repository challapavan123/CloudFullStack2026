package com.myapp.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.aop.LoginManagerBean;
import com.myapp.spring.config.AppConfig;
import com.myapp.spring.service.MovieSearchService;

//@SpringBootApplication
public class SpringCoreDemo1Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringCoreDemo1Application.class, args);

AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
LoginManagerBean loginManagerBean= container.getBean(LoginManagerBean.class);
loginManagerBean.login("admickkdjn", null);
loginManagerBean.logout();
MovieSearchService searchService =  container.getBean(MovieSearchService.class);

MovieSearchService searchService1 =  container.getBean(MovieSearchService.class);

System.out.println("Singleton "+searchService.equals(searchService1));
searchService.search("The Matrix").forEach(System.out::println);

container.close();
	}

}
