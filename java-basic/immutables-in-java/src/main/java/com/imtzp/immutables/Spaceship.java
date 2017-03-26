package com.imtzp.immutables;

public class Spaceship {

	private String name;

	private Destination destination;

	public Spaceship(String name, Destination destination) {
		this.name = name;
		this.destination = destination;
	}

	public Destination currentDestination() {
		return destination;
	}

	public Spaceship exploreGalaxy() {
		destination = Destination.OUTER_SPACE;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
