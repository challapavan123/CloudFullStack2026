package com.myapp.spring.boot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRecord {

    private String description;
    private LocalDateTime createdDate;
    private String status;

}
