package org.ibm.oops;

public abstract class Shape {

    private double width;
    private double height;

    

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //getters and setters for width and height
    public double getWidth() {
        return width;   
    }   

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width; 
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public  double calculateArea();
}
