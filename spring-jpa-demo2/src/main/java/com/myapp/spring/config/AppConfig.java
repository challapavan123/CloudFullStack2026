package com.myapp.spring.config;

import javax.sql.DataSource;

import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.myapp.spring")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.myapp.spring.repository")
public class AppConfig {

    @Bean
    DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://ep-withered-leaf-au1dxeid.c-10.us-east-1.aws.neon.tech/neondb");
        dataSource.setUsername("neondb_owner");
        dataSource.setPassword("npg_2sMvn7LRIdti");
        dataSource.setMaximumPoolSize(10);
        dataSource.setMinimumIdle(2);
        dataSource.setAutoCommit(false);
        return dataSource;

    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        vendor.setGenerateDdl(true);
        vendor.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendor);
        factory.setPackagesToScan("com.myapp.spring.domain");
        
        //factory.setPersistenceUnitName("moviePersistenceUnit");
        
        return factory;
    }
    

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
