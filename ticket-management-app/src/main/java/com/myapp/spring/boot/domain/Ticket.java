package com.myapp.spring.boot.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tickets")
@Data
public  class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name="created_date")
    private LocalDateTime createdDate;

    @Column(name="closed_date")
    private LocalDateTime closedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="assignedAgent")
    private Agent assignedAgent;

    @PrePersist
    void prePersist(){

        if(createdDate == null){
            createdDate = LocalDateTime.now();
        }
        if(status == null){
            status= Status.NEW;
        }

    }


}


