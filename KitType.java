package com.gmail.certifieddev33.Minigame;

public enum KitType {

	BARBARIAN("Barbarian"), ARCHER("Archer");

	private final String name;

	private KitType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static boolean isKit(String name) {
		return getKit(name) != null;
	}
	
	public static KitType getKit(String name) {
		for (KitType type : values()) {
			if (type.toString().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}

}