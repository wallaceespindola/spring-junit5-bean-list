package com.wtech.core.parts;

public class Transmission {

	private final String type;

	public Transmission(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Trans %s", type);
	}
}
