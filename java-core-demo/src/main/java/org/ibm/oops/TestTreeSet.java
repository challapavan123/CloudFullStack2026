package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
         LinkedList<Transaction1> transactions = new LinkedList<>();
         transactions.addLast(new Transaction1(3L, 75568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.addFirst(new Transaction1(2L, 35568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction1(1L, 45568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction1(4L, 45568.6, "Payment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        
        Set<Transaction1> set = new TreeSet<>((t1,t2)-> t1.getAmount().compareTo(t2.getAmount()));
        set.addAll(transactions);
        System.out.println("set size"+set.size());
    }

}
