package org.ibm.oops;

public class MarkerImpl implements Marker {


    public void checkMarker() {
       if(this instanceof Marker) {
           System.out.println("This object is marked with the Marker interface.");
       } else {
           System.out.println("This object is NOT marked with the Marker interface.");
       }
    }
}
