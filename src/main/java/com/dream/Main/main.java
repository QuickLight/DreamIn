package com.dream.Main;

import com.dream.Listener.listeners;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new listeners(), this);
    }
}
