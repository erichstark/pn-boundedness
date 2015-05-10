package com.erichstark.base;

/**
 * Created by Erich on 10/05/15.
 *
 * Trieda reprezentujuca Hrany
 */
public class Arc {
	// typ hrany
	private String type;

	// zdrojove id - z ktoreho miesta zacina
	private int sourceId;

	// konecne id - kde hrana konci
	private int destinationId;

	// nasobnost hrany
	private int multiplicity;

	public Arc() {
	}

	public Arc(String type, int sourceId, int destinationId, int multiplicity) {
		this.type = type;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.multiplicity = multiplicity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
	}
}
