package com.myapp.spring.boot.repository;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.myapp.spring.boot.dto.TicketCsv;
import com.myapp.spring.boot.dto.TicketRecord;

@Component
public class TicketProcessor implements ItemProcessor<TicketCsv,TicketRecord> {

    @Override
    public @Nullable TicketRecord process(TicketCsv item) throws Exception {
       if (item.description() == null ||
                item.description().isBlank()) {

            // Returning null filters out the record.
            return null;
        }

        return new TicketRecord(
                item.description().trim(),
                LocalDateTime.now(),
                item.status().toUpperCase()
        );
    }
    



}
