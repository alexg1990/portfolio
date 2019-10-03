package de.tuberlin.mcc.prog1.logistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Prog1Tools.IOTools;

public class LogisticsManager {
	
	/**
	 * List of commands.
	 */
	public static final int LISTLOCATIONS = 0;
	public static final int CREATELOCATION = 1;
	public static final int LISTDELIVERIES = 2;
	public static final int REGISTERDELIVERY = 3;
	public static final int ADJUSTWEIGHT = 4;
	public static final int ADJUSTRECEIVER = 5;
	public static final int EXIT = 6;
	
	/**
	 * Available locations.
	 */
	public static Location[] locations = new Location[30];

	/**
	 * Starts Manager.
	 * @param args - not defined yet
	 */
	public static void main(String[] args) {
		
		//Create and add some locations.
		locations[0] = Location.createLocationFrom("Berlin", 75, 25);
		locations[1] = Location.createLocationFrom("Hamburg", 25, 10);
		locations[2] = Location.createLocationFrom("Köln", 10, 50);
		locations[3] = Location.createLocationFrom("München", 60, 70);
		locations[4] = Location.createLocationFrom("Frankfurt", 25, 60);
		locations[5] = Location.createLocationFrom("Stuttgart", 20, 80);
		
		//Create a manager for deliveries.
		DeliveryManager deliveryManager = new DeliveryManager();
		// Register some deliveries from inputdata.csv
		deliveryManager.registerDeliveries(preloadInitialDataSet());
		
		//Run user interface
		System.out.println("Welcome to the logistics management system!");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:"
					+ "\n0 to list all locations"
					+ "\n1 to create a new location"
					+ "\n2 to list all registered deliveries"
					+ "\n3 to register a new delivery"
					+ "\n4 to adjust the weight of an already registered delivery" 
					+ "\n5 to adjust the receiver of an already registered delivery" 
					+ "\n6 to exit.");
			int command = IOTools.readInt();
			switch (command) {
				case LISTLOCATIONS :
					printLocations();
					break;
				case CREATELOCATION :
					Location l = Location.createLocationFromUserInput();
					addLocation(l);
					break;
				case LISTDELIVERIES :
					deliveryManager.printDeliveries();
					break;				
				case REGISTERDELIVERY :
					printLocations();
					int sender = IOTools.readInt("LocationID of sender:");
					int receiver = IOTools.readInt("LocationID of receiver:");
					Delivery d = Delivery.createDeliveryUsing(DeliveryManager.getLocationById(sender), DeliveryManager.getLocationById(receiver));
					if (d != null) {
						deliveryManager.registerDeliveries(d);
						System.out.println("The following delivery has been added to the system:\n"
									+ d.toString());
					} else {
						System.out.println("Unable to add delivery");
					}
					break;
				case ADJUSTWEIGHT :
					deliveryManager.printDeliveries();
					int index = IOTools.readInt("Please, enter index of delivery:");
					double weight = IOTools.readDouble("Please, enter new weight for this delivery:");
					deliveryManager.setWeightForDelivery(index, weight);
					break;
				case ADJUSTRECEIVER :
					deliveryManager.printDeliveries();
					int idx = IOTools.readInt("Please, enter index of delivery:");
					printLocations();
					int locationID = IOTools.readInt("Please, enter locationID of new receiver:");
					deliveryManager.setReceiverForDelivery(idx, locationID);
					break;
				case EXIT :
					running = false;
					break;
				default :
					System.out.println("Unknown command: " + command);
					break;
			}
		}
		System.out.println("Byebye!");
	}
	
	/**
	 * Loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Delivery[], will never be null but may have length 0
	 */
	public static Delivery[] preloadInitialDataSet() {
		BufferedReader br = null;
		try {
			//Create reader to read input files
			br = new BufferedReader(new FileReader("inputdata.csv"));
			//Create list to store data from file
			ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
			String line;
			//Read each line from file
			while ((line = br.readLine()) != null) {
				//Split line by ';'
				String[] splits = line.split(";");
				if (splits.length == 3) {
					//Assign values
					int senderID = Integer.parseInt(splits[0]);
					int receiverID = Integer.parseInt(splits[1]);
					double weight = Double.parseDouble(splits[2]);
					//Create Delivery
					Delivery d = Delivery.createDeliveryUsing(DeliveryManager.getLocationById(senderID), DeliveryManager.getLocationById(receiverID), weight);
					if (d != null) {
						//only add if delivery was created
						deliveries.add(d);
					}
				} else {
					System.out.println("Could not process line:" + line);
				}
			}
			//convert list into array
			return deliveries.toArray(new Delivery[deliveries.size()]);

		} catch (Exception e) {
			// Some failure handling
			System.out.println("There was an error while trying to load the initial data set:");
			e.printStackTrace();
			return new Delivery[0];
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * Prints available locations.
	 */
	public static void printLocations() {
		System.out.println("Locations:");
		for (Location l : locations) {
			if (l != null) {
				System.out.println(l.toString());
			}
		}
	}
	
	/**
	 * Adds a location.
	 * @param l - location to add
	 */
	public static void addLocation(Location l) {
		for (int i = 0; i < locations.length; i++) {
			if (locations[i] == null) {
				locations[i] = l;
				return;
			}
		}
		System.out.println("Unable to add " + l.toString() + "(to many locations).");
	}	

}
