package io.github.optimumportal.mobsteroids;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.optimumportal.mobsteroids.listeners.Listeners;

public class MobSteroids extends JavaPlugin {
  private static MobSteroids instance;
  
  public static MobSteroids getInstance() {
    return instance;
  }
  
  public void onEnable() {
    instance = this;
    getServer().getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);
  }
  
  public void onDisable() {
    instance = null;
  }
}