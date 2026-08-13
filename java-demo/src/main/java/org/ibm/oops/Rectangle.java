package org.ibm.oops;

public class Rectangle extends Shape {

    public Rectangle() {
            super(0, 0); // Default width and height to 0
    }   
    public Rectangle(double width, double height) {
       
        super(width, height);

    }

    public double calculateArea() {
        return getWidth() * getHeight();
    }

}
