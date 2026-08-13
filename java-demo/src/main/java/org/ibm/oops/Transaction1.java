package org.ibm.oops;

public class Transaction1 {
    private final long transactionId;
    private final double amount;    
    private final String description;

    public Transaction1(long transactionId, double amount, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
    }
    //getters for transactionId, amount, and description
    public long getTransactionId() {
        return transactionId;       
    }   
    public double getAmount() {
        return amount;
    }
    public String getDescription() {
        return description; 
    }   
    

}
