package com.myapp.spring.boot.rest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myapp.spring.boot.domain.Ticket;

@RepositoryRestResource(path = "tickets",collectionResourceRel = "tickets")
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
