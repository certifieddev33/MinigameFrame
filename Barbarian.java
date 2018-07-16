package com.gmail.certifieddev33.Minigame;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class Barbarian extends Kit {

	public Barbarian(UUID uuid) {
		super(uuid, KitType.BARBARIAN, Helper.createItem(ChatColor.GREEN, "Barbarian's Sword", Material.STONE_SWORD));
	}

	@Override
	public void onStart(Player player) {

	}

	@Override
	public void update(Player player, int time) {

	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}

		final Player player = (Player) event.getEntity();

		if (uuid != player.getUniqueId()) {
			return;
		}

		event.setDamage(event.getDamage() - 1);
	}

}
