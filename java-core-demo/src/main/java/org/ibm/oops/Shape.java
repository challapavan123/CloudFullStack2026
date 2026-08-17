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

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shape other = (Shape) obj;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        return true;
    }

    public  abstract double calculateArea();
}
