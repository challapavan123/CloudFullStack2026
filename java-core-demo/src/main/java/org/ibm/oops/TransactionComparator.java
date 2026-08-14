package org.ibm.oops;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction>{

    @Override
    public int compare(Transaction o1, Transaction o2) {
        // TODO Auto-generated method stub
        return o1.transactionDate().compareTo(o2.transactionDate());
    }
}
