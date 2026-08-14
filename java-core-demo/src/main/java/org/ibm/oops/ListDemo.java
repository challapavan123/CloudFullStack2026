package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {

    public static void main(String[] args) {
        
        List<Transaction1> transactions = new ArrayList<>();
         transactions.add(new Transaction1(1L, 75568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction1(1L, 35568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction1(1L, 45568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));

        System.out.println("List Size"+transactions.size());

        Set<Transaction1> setTransactions = new HashSet<>();
        setTransactions.addAll(transactions);
        System.out.println("Set Size "+setTransactions.size());

        // Stream Consists of 3 Distinct Parts
        // 1. Source // where the data originates
        // 2. Intermediate Operations (filter, map)
        // 3. Terminal Operations (collect, reduce)


        //List list1 = new ArrayList();
    }

}
