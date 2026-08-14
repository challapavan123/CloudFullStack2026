package org.ibm.oops;

import java.time.LocalDateTime;

public record Transaction(long transactionId,
    Double amount,
     String description, LocalDateTime transactionDate) implements Comparable<Transaction> {

    @Override
    public int compareTo(Transaction other) {
        return Double.compare(this.amount, other.amount);
    }

}
