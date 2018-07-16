package com.gmail.certifieddev33.Minigame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Minigame extends JavaPlugin {

	private static Minigame instance;

	public static Minigame getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		
		Manager.setup();

		registerCommands();
		registerListeners();
	}

	@Override
	public void onDisable() {

	}

	private void registerCommands() {
		getCommand("arena").setExecutor(new CommandArena());
		getCommand("kit").setExecutor(new CommandKit());
	}

	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DeathListener(), this);
		pm.registerEvents(new PreventionListener(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new LeaveListener(), this);
	}

}
