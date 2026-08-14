package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OlStyleSort {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1L, 45678.5,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(2L, 55568.6, "Funds Transfer",LocalDateTime.of(2026,Month.JANUARY,23,15,16)));
        transactions.add(new Transaction(0, 32457.5, "Movie Booking",LocalDateTime.now()));

        // Collections.sort(transactions, new Comparator<Transaction>() {
        //     @Override
        //     public int compare(Transaction o1, Transaction o2) {
        //         // TODO Auto-generated method stub
        //         return o1.transactionDate().compareTo(o2.transactionDate());
        //     }
        // });
        Collections.sort(transactions, new TransactionComparator());

        System.out.println(transactions);
    }

}

// function name(){
//}
// const name =() =>
    // Lambda
// () -> {}