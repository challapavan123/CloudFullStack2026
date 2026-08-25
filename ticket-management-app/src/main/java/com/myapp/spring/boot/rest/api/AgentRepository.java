package com.myapp.spring.boot.rest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myapp.spring.boot.domain.Agent;

@RepositoryRestResource(path = "agents",
collectionResourceRel = "agents")
public interface AgentRepository  extends JpaRepository<Agent,Long>{

}
