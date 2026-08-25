package com.myapp.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.database.JdbcBatchItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.myapp.spring.boot.dto.TicketCsv;
import com.myapp.spring.boot.dto.TicketRecord;
import com.myapp.spring.boot.repository.TicketProcessor;

@Configuration
public class TicketBatchConfiguration {

    @Bean
    FlatFileItemReader<TicketCsv> ticketReader(){
        String s2 = new String("abcd");
        s2.intern();

        return new FlatFileItemReaderBuilder<TicketCsv>()
                .name("ticketCsvReader")
                .resource(
                    new ClassPathResource("data/tickets.csv")
                )
                .linesToSkip(1)
                .delimited()
                .delimiter(",")
                .names("description", "status")
                .targetType(TicketCsv.class)
                .build();
    }

    @Bean
    JdbcBatchItemWriter<TicketRecord> ticketWriter(DataSource dataSource){
  return new JdbcBatchItemWriterBuilder<TicketRecord>()
                .dataSource(dataSource)
                .sql("""
                    INSERT INTO tickets
                        (description, created_date, status)
                    VALUES
                        (:description, :createdDate, :status)
                    """)
                .itemSqlParameterSourceProvider(
                        BeanPropertySqlParameterSource::new
                )
                .build();

    }
    

    @Bean
    Step importTicketsStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<TicketCsv> ticketReader,
            TicketProcessor ticketProcessor,
            JdbcBatchItemWriter<TicketRecord> ticketWriter) {

        return new StepBuilder(
                    "importTicketsStep",
                    jobRepository
                )
                .<TicketCsv, TicketRecord>chunk(10)
                .transactionManager(transactionManager)
                .reader(ticketReader)
                .processor(ticketProcessor)
                .writer(ticketWriter)
                .build();
    }


}
