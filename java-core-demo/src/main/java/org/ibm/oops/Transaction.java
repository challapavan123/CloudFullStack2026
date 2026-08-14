package org.ibm.oops;

public record Transaction(long transactionId,
    double amount,
     String description) implements Comparable<Transaction> {

    @Override
    public int compareTo(Transaction other) {
        return Double.compare(this.amount, other.amount);
    }

}
