package com.myapp.spring.boot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Agent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
