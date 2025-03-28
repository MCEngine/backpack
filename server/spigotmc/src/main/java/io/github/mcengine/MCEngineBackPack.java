package io.github.mcengine;

import io.github.mcengine.api.MCEngineBackPackApi;
import io.github.mcengine.common.backpack.command.MCEngineBackPackCommonCommand;
import io.github.mcengine.common.backpack.listener.MCEngineBackPackCommonListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MCEngineBackPack extends JavaPlugin {
    private MCEngineBackPackUtil backPackUtil;

    @Override
    public void onEnable() {
        backPackUtil = new MCEngineBackPackUtil(this);
        backPackUtil.saveResourceIfNotExists("heads/default.yml");
        getLogger().info("MCEngineBackPack has been enabled.");
        // Register Command
        getCommand("backpack").setExecutor(new MCEngineBackPackCommonCommand(new MCEngineBackPackApi(this)));
        // Register Listener
        getServer().getPluginManager().registerEvents(new MCEngineBackPackCommonListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("MCEngineBackPack has been disabled.");
    }
}
