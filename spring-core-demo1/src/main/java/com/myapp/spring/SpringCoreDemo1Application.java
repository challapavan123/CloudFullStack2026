package com.myapp.spring;


import org.springframework.aop.support.AopUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.aop.LoginManagerBean;
import com.myapp.spring.config.AppConfig;
import com.myapp.spring.domain.Movie;
import com.myapp.spring.repository.MovieJdbcRepository;
import com.myapp.spring.service.MovieSearchService;
import com.myapp.spring.service.MovieSearchServiceImpl;

//@SpringBootApplication
public class SpringCoreDemo1Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringCoreDemo1Application.class, args);

AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

MovieJdbcRepository repository = container.getBean(MovieJdbcRepository.class);

System.out.println("AOP Proxy "+AopUtils.isAopProxy(repository));

repository.recommendations("Inception").forEach(System.out::println);
// System.out.println(
// repository.save(new Movie("1", "Inception", "Science Fiction",
//      "A thief enters dreams to steal secrets." )));
// LoginManagerBean loginManagerBean= container.getBean(LoginManagerBean.class);
// loginManagerBean.login("admin", null);
// //loginManagerBean.logout();
// MovieSearchService searchService =  container.getBean(MovieSearchService.class);


// System.out.println("AOP Proxy "+AopUtils.isAopProxy(searchService));
// System.out.println("CGLIB Proxy "+AopUtils.isCglibProxy(searchService));
// MovieSearchServiceImpl searchService1 =  container.getBean(MovieSearchServiceImpl.class);



//System.out.println("Singleton "+searchService.equals(searchService1));
//searchService.search("The Matrix").forEach(System.out::println);

container.close();
	}

}
