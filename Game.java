package com.gmail.certifieddev33.Minigame;

import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Game extends BukkitRunnable {

	private final Arena arena;
	private int time;

	public Game(Arena arena) {
		this.arena = arena;
		this.time = 0;
	}

	public void start() {
		arena.setState(GameState.STARTED);
		arena.broadcast(ChatColor.AQUA + "The game has started!");

		for (Entry<UUID, Kit> entry : arena.getKits().entrySet()) {
			Player player = Bukkit.getPlayer(entry.getKey());
			Kit kit = entry.getValue();

			Helper.clearInventoryAndEffects(player);

			kit.onStart(player);

			player.teleport(arena.getLocation());

			for (int i = 0; i < kit.getItems().length; i++) {
				player.getInventory().addItem(kit.getItems()[i]);
			}
		}
		this.runTaskTimer(Minigame.getInstance(), 0L, 20L);
	}

	@Override
	public void run() {

		for (Entry<UUID, Kit> entry : arena.getKits().entrySet()) {
			entry.getValue().update(Bukkit.getPlayer(entry.getKey()), time);
		}

		time++;
	}

}