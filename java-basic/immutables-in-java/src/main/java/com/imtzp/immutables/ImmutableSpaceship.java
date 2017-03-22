package com.imtzp.immutables;

public final class ImmutableSpaceship {

	private final String name;
	private final Destination destination;

	public ImmutableSpaceship(String name) {
		this.name = name;
		this.destination = new Destination("NONE");
	}

	private ImmutableSpaceship(String name, Destination destination) {
		this.name = name;
		this.destination = new Destination(destination);
	}

	public Destination currentDestination() {
		return new Destination(destination);
	}

	public ImmutableSpaceship newDestination(Destination newDestination) {
		return new ImmutableSpaceship(this.name, newDestination);
	}

	public String getName() {
		return name;
	}

	public Destination getDestination() {
		return destination;
	}
}
