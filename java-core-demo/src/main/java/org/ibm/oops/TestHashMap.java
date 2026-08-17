package org.ibm.oops;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer,Transaction> map = new HashMap<>();

        map.put(1, new Transaction(3L, 75568.6,"GroceryPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));

        map.put(3, new Transaction(4L, 35568.6,"UtiityPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));

        map.put(2, new Transaction(2L, 25568.6,"UtiityPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));
    

        map.putIfAbsent(null, new Transaction(5L, 15568.6,"UtiityPayment",LocalDateTime.of(2025,Month.FEBRUARY,21, 12, 13)));

        System.out.println("Map Size "+map.size());
        System.out.println(map.get(2));
        System.out.println(map.get(null));
        System.out.println(map.keySet());
    }

}
