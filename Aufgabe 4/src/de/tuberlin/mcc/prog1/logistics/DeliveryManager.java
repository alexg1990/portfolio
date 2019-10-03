package de.tuberlin.mcc.prog1.logistics;

public class DeliveryManager {
	
	/**
	 * Available locations
	 */
	static Location[] locations =  LogisticsManager.locations;
	
	public void registerDeliveries(Delivery... deliveries) {
		
	}
	
	public void setWeightForDelivery(int index, double weight) {
		
	}
	
	public void setReceiverForDelivery(int index, int locationId) {
		
	}
	
	/**
	 * Searches in Location[] locations (see above) for a location with given ID. 
	 * @param id - Id of location to look up
	 * @return location with given id or null if there is no such location
	 */
	public static Location getLocationById(int id) {
		for (Location l : locations) {
			if (l != null && l.getId() == id) {
				return l;
			}
		}
		return null;
	}

}
