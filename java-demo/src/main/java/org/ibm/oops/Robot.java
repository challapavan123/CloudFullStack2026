package org.ibm.oops;

public class Robot {

    private int batteryLevel;
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        if(batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Battery level must be between 0 and 100");
        }
        this.batteryLevel = batteryLevel;
    }
    public void performTask() {
        if(batteryLevel >=10 ) {
            batteryLevel -= 10; // Decrease battery level by 10 for each task
            System.out.println("Performing task... Battery Level: " + batteryLevel);
        } else {
            System.out.println("Battery is empty. Please recharge.");
        } 
    }   
}
