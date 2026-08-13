package org.ibm.oops;


public class JavaDemoApplication {

	public static void main(String[] args) {
		
		Robot robot = new Robot();
		robot.setBatteryLevel(100);
		robot.performTask();
		robot.performTask();	

		Persistable document = new FileDocument("document.txt");
		document.save();
		document.load();
		document.delete();
		Persistable user = new User("John Doe", 30);
		user.save();
		user.load();	
		user.delete();

		MarkerImpl markerImpl = new MarkerImpl();
		markerImpl.checkMarker(); // Check if markerImpl is marked with the Marker interface

		CPU.Cache cache = new CPU.Cache(16 * 1024 * 1024); // Create a cache with 16 MB size	
		cache.printCacheInfo();

		Transaction transaction = 
		new Transaction(12345L, 250.75, "Payment for services");
		transaction.transactionId(3763763763L)
		// Create a cache with 16 MB size	
		//new Shape(23.4,34.5)
		// robot.batteryLevel = 100;
		// System.out.println("Battery Level: " 
		// + robot.batteryLevel);
	}

}

// Why nested Classes
// 1 . Logical Grouping of classes that are only used in one place
// 2. Increase Encapsulation
// 3. More readable and maintainable code
