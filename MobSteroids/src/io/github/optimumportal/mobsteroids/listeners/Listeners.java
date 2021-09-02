package io.github.optimumportal.mobsteroids.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import io.github.optimumportal.mobsteroids.MobSteroids;
import net.md_5.bungee.api.ChatColor;


public class Listeners implements Listener {
	  boolean ZombieEnabled = MobSteroids.getInstance().getConfig().getBoolean("zombie.enabled");
	  boolean SkeletonEnabled = MobSteroids.getInstance().getConfig().getBoolean("skeleton.enabled");
	  boolean ZombieMsgEnabled = MobSteroids.getInstance().getConfig().getBoolean("zombie.enable-modify-message");
	  boolean SkeletonMsgEnabled = MobSteroids.getInstance().getConfig().getBoolean("skeleton.enable-modify-message");
	  String prefix = MobSteroids.getInstance().getConfig().getString("prefix");
	  String ZombieMsg = MobSteroids.getInstance().getConfig().getString("zombie.modify-message");
	  String SkeletonMsg = MobSteroids.getInstance().getConfig().getString("skeleton.modify-message");
	  String ConfigZombieHelmet = MobSteroids.getInstance().getConfig().getString("zombie.helmet");
	  String ConfigZombieChestplate = MobSteroids.getInstance().getConfig().getString("zombie.chestplate");
	  String ConfigZombieLeggings = MobSteroids.getInstance().getConfig().getString("zombie.leggings");
	  String ConfigZombieBoots = MobSteroids.getInstance().getConfig().getString("zombie.boots");
	  
	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) {
		if (event.getEntityType() == EntityType.ZOMBIE) {
			if(ZombieEnabled == true) {
			Zombie zombie = (Zombie)event.getEntity();
			Material zombiehelmet = Material.matchMaterial(ConfigZombieHelmet);
			Material zombiechestplate = Material.matchMaterial(ConfigZombieChestplate);
			Material zombieleggings = Material.matchMaterial(ConfigZombieLeggings);
			Material zombieboots = Material.matchMaterial(ConfigZombieBoots);
			zombie.getEquipment().setHelmet(new ItemStack(zombiehelmet));
			zombie.getEquipment().setChestplate(new ItemStack(zombiechestplate));
			zombie.getEquipment().setLeggings(new ItemStack(zombieleggings));
			zombie.getEquipment().setBoots(new ItemStack(zombieboots));
				if (ZombieMsgEnabled == true) {
					Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + prefix + ZombieMsg);
				}
				}
			}
		if (event.getEntityType() == EntityType.SKELETON) {
			Skeleton skeleton = (Skeleton)event.getEntity();
			if(SkeletonEnabled == true) {
			skeleton.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			skeleton.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			
			ItemStack skeletonBow = new ItemStack(Material.BOW);
			skeletonBow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			skeletonBow.addEnchantment(Enchantment.ARROW_FIRE, 1);
			skeleton.getEquipment().setItemInMainHand(skeletonBow);
			if (SkeletonMsgEnabled == true) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + prefix + SkeletonMsg);
			}
			}
		}
	}
}