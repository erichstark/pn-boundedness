package com.erichstark.base;

/**
 * Created by Erich on 10/05/15.
 *
 * Trieda reprezentujuca Miesto
 */
public class Place {
	// idcko miesta
	private int id;

	// popisok miesta
	private String label;

	// pocet tokenov v mieste
	private int tokens;

	// ci je staticke
	private boolean isStatic;

	public Place() {
	}

	public Place(int id, String label, int tokens, boolean isStatic) {
		this.id = id;
		this.label = label;
		this.tokens = tokens;
		this.isStatic = isStatic;
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

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setIsStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
}
