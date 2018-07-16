package com.gmail.certifieddev33.Minigame;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Manager {

	public final static Location SPAWN_POINT = new Location(Bukkit.getWorld("world"), 0.0, 10.0, 0.0);

	public static void setup() {

		for (int i = 1; i <= 10; i++) {
			new Arena(i, new Location(Bukkit.getWorld("world"), 50.0, 10.0,
					50.0));
		}
	}

	private static Manager manager;

	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}

	private ArrayList<Arena> arenas;

	private Manager() {
		this.arenas = new ArrayList<Arena>();
	}

	public void addArena(Arena arena) {
		arenas.add(arena);
	}

	public void removeArena(Arena arena) {
		arenas.remove(arena);
	}

	public Arena getArena(int id) {
		for (int i = 0; i < arenas.size(); i++) {
			final Arena arena = arenas.get(i);

			if (arena.getId() == id) {
				return arena;
			}
		}
		return null;
	}

	public boolean isArena(int id) {
		return getArena(id) != null;
	}

	public Arena getArena(UUID uuid) {
		for (int i = 0; i < arenas.size(); i++) {
			final Arena arena = arenas.get(i);

			if (arena.contains(uuid)) {
				return arena;
			}
		}
		return null;
	}

}
