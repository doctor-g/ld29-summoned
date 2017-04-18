package edu.bsu.pvgestwicki.ld29.core;

import react.Value;

public enum Attribute {

	PHYSIQUE("Physique"), //
	INTELLECT("Intellect"), //
	WILLPOWER("Willpower"), //
	FATE("Fate");

	public final String name;
	public final Value<Integer> value = Value.create(DEFAULT_VALUE);

	private Attribute(String name) {
		this.name = name;
	}

	private static final int DEFAULT_VALUE = 2;

	public static void reset() {
		for (Attribute a : values()) {
			a.value.update(DEFAULT_VALUE);
		}
	}

	public int asInt() {
		return value.get().intValue();
	}

}
