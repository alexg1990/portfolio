package de.tuberlin.mcc.prog1.logistics;

public class Delivery {
	private Location sender;
	private Location receiver;
	private long date;
	private double weight;
	public Location getSender() {
		return sender;
	}
	public Location getReceiver() {
		return receiver;
	}
	void setReceiver(Location receiver) {
		if (receiver != null) {
			this.receiver = receiver;
		} else {
			System.out.println("Zielort ungültig.");
		}
	}
	public long getDate() {
		return date;
	}
	public double getWeight() {
		return weight;
	}
	void setWeight(double weight) {
		if (weight >= 0) {
			this.weight = weight;
		} else {
			System.out.println("Gewicht ungültig!");
		}
	}
	public static Delivery createDeliveryUsing(Location sender, Location receiver, double weight) {
		Delivery delivery = new Delivery();
		delivery.date = System.currentTimeMillis();
		delivery.sender = sender;
		delivery.receiver = receiver;
		delivery.weight = weight;
		return delivery;
	}
	public static Delivery createDeliveryUsing (Location sender, Location receiver) {
		Delivery delivery = new Delivery();
		delivery.date = System.currentTimeMillis();
		delivery.sender = sender;
		delivery.receiver = receiver;
		delivery.weight = 0.5;
		return delivery;
	}
	public long getEstimatedDeliveryTime(Delivery delivery) {
		long timeToDeliver = delivery.sender.getxPosition()…
	}

	
}
