package com.gmail.certifieddev33.Minigame;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Archer extends Kit {

	public Archer(UUID uuid) {
		super(uuid, KitType.ARCHER, Helper.createItem(ChatColor.GREEN, "Archer's Bow", Material.BOW),
				Helper.createItem(ChatColor.GREEN, "Archer's Arrow", Material.ARROW));
	}

	@Override
	public void onStart(Player player) {

	}

	@Override
	public void update(Player player, int time) {

	}

}