package com.gmail.certifieddev33.Minigame;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		Arena arena = Manager.getInstance().getArena(player.getUniqueId());
		if (arena != null) {
			arena.removePlayer(player.getUniqueId());
			arena.broadcast(ChatColor.RED + player.getName() + " left the server, so has been removed from the arena.");
		}
	}

}