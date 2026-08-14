package org.ibm.oops;

import java.time.LocalDateTime;

public class Transaction1 extends Object{
    private final long transactionId;
    private final double amount;    
    private final String description;
    private LocalDateTime transactionDateTime;

    public Transaction1(long transactionId, double amount, String description,
        LocalDateTime transactionDateTime
    ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
        this.transactionDateTime = transactionDateTime;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((transactionDateTime == null) ? 0 : transactionDateTime.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction1 other = (Transaction1) obj;
        if (transactionId != other.transactionId)
            return false;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (transactionDateTime == null) {
            if (other.transactionDateTime != null)
                return false;
        } else if (!transactionDateTime.equals(other.transactionDateTime))
            return false;
        return true;
    }   
    
    

}
