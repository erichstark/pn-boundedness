package com.erichstark.base;

/**
 * Created by Erich on 10/05/15.
 *
 * Trieda reprezentujuca Prechod
 */
public class Transition {
	// id prechodu
	private int id;

	// nazov prechodu
	private String label;

	public Transition() {
	}

	public Transition(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
