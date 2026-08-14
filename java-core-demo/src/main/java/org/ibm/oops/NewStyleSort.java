package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewStyleSort {

    public static void main(String[] args) {
        Set<Transaction> transactions = new HashSet<>();
         transactions.add(new Transaction(1L, 55568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(2L, 55568.6, "Funds Transfer",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(3L, 55568.6, "Movie Booking",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        // transactions.add(new Transaction(1L, 55568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        // transactions.add(new Transaction(2L, 55568.6, "Funds Transfer",LocalDateTime.of(2026,Month.JANUARY,23,15,16)));
        // transactions.add(new Transaction(4L, 55568.6, "Movie Booking",LocalDateTime.now()));

        // Collections.sort(transactions, new Comparator<Transaction>() {
        //     @Override
        //     public int compare(Transaction o1, Transaction o2) {
        //         // TODO Auto-generated method stub
        //         return o1.transactionDate().compareTo(o2.transactionDate());
        //     }
        // });
        // Comparator<Transaction> comparator = ( t1, t2) ->
        //         t1.amount().compareTo(t2.amount());
        // Collections.sort(transactions, 
        //     comparator.thenComparing(Transaction::transactionDate));


            Comparator<Transaction> comparator1 = ( t1, t2) ->
                t1.amount().compareTo(t2.amount());
        Collections.sort(transactions, 
            comparator1.thenComparing((t1,t2)-> t1.transactionDate().compareTo(t2.transactionDate())));
           // System.out.println(transactions);
        

          

        System.out.println(transactions);
    }

}

// function name(){
//}
// const name =() =>
    // Lambda
// () -> {}