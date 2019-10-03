package de.tuberlin.mcc.prog1.logistics;

import Prog1Tools.IOTools;

public class Location {
	private String name;
	private int xPosition;
	private int yPosition;
	private int id = nextID++;
	static int nextID = 0;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getxPosition() {
		return this.xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return this.yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public int getID() {
		return this.id;
	}
	
	public static Location createLocationFrom(String name, int xPosition, int yPosition) {
		Location location = new Location();
		location.setName(name);
		location.setxPosition(xPosition);
		location.setyPosition(yPosition);
		return location;
	}
	
	public String toString(Location location) {
		String locationDescription = location.name + " hat die Koordinaten x:" + location.xPosition + " y:" + location.yPosition + "und die ID:" + location.id;
		return locationDescription;
	}
	
	public static Location createLocationFromUserInput() {
		String name = IOTools.readString("Wie heißt die Stadt?");
		int xPosition = IOTools.readInt("Wie ist die X Koordinate von der Stadt?");
		int yPosition = IOTools.readInt("Wie ist die Y Koordinate von der Stadt?");
		Location location = createLocationFrom(name, xPosition, yPosition);
		return location;
	}
}
