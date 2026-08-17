package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ListDemoStreams {

    public static void main(String[] args) {
        
        List<Transaction> transactions = new ArrayList<>();
         transactions.add(new Transaction(1L, 75568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(1L, 35568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(1L, 45568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));

        System.out.println("List Size"+transactions.size());

        Set<Transaction> setTransactions = new HashSet<>();
        setTransactions.addAll(transactions);
        System.out.println("Set Size "+setTransactions.size());

        // Stream Consists of 3 Distinct Parts
        // 1. Source // where the data originates
        // 2. Intermediate Operations (filter, map)
        // 3. Terminal Operations (collect, reduce)


        //List list1 = new ArrayList();

        // source operation

        Stream<Transaction> streams=  setTransactions.stream();

        // intermediate operations
  DoubleSummaryStatistics stats= 
  streams.filter(transaction ->  transaction.amount()>= 45000.0)
  .mapToDouble(Transaction::amount).summaryStatistics();
        // Streams are Lazy
        // One more intermediate Operation
      
      
        System.out.println("Min Value "+stats.getMin());
        System.out.println("Max Value "+stats.getMax());
        System.out.println("Average Value "+stats.getAverage());
        System.out.println("Sum of All Transactions "+stats.getSum());

    }

}
