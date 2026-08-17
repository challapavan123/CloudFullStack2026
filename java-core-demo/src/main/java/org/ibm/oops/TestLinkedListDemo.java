package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedListDemo {

    public static void main(String[] args) {
         LinkedList<Transaction> transactions = new LinkedList<>();
         transactions.addLast(new Transaction(3L, 75568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.addFirst(new Transaction(2L, 35568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
        transactions.add(new Transaction(1L, 45568.6, "GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
System.out.println(transactions);

ListIterator<Transaction> listIterator = transactions.listIterator();
while (listIterator.hasNext()) {
    if(listIterator.nextIndex() ==1){
        listIterator.add(new Transaction(4L, null, null, null));
    }
    
}
    }

}
