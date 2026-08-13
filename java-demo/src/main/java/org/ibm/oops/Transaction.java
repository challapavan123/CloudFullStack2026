package org.ibm.oops;

public record Transaction(long transactionId,
    double amount,
     String description) {

}
