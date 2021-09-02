package io.github.optimumportal.mobsteroids;

import java.io.File;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.optimumportal.mobsteroids.listeners.Listeners;

public class MobSteroids extends JavaPlugin {
  private static MobSteroids instance;
  
  
  @Override
  public void onEnable() {
    instance = this;
    getServer().getPluginManager().registerEvents((Listener)new Listeners(), (org.bukkit.plugin.Plugin)this);
    
    File config = new File(getDataFolder() + File.separator + "config.yml");
    if(!config.exists()) {
    	this.getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
    }  
  }
  
  public void onDisable() {
    instance = null; //Stops memory leaks.
  } 
  
  public static MobSteroids getInstance() {
	    return instance; //Access methods from other classes.
}
}
  