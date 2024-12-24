package com.github.roitoayanokoji.dice_ver11;

import org.bukkit.plugin.java.JavaPlugin;

public final class Dice_ver11 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("OnEnable");

        //DiceCommandExecutorで処理
        getCommand("dice").setExecutor(new DiceCommandExecutor(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("OnDisable");
    }
}
