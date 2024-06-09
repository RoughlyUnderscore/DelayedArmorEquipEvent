package com.jeff_media.armorequipevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static com.jeff_media.armorequipevent.TaskUtils.delayed;

/**
 * @author Arnah
 * @since Feb 08, 2019
 */
class DispenserArmorListener implements Listener{
	private final JavaPlugin plugin;

	public DispenserArmorListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onArmorDispense(BlockDispenseArmorEvent event){
		ArmorType type = ArmorType.matchType(event.getItem());
		if(type != null){
			if(event.getTargetEntity() instanceof Player){
				Player p = (Player) event.getTargetEntity();
				ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p, ArmorEquipEvent.EquipMethod.DISPENSER, type, null, event.getItem());
				delayed(plugin, () -> Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent));
				if(armorEquipEvent.isCancelled()){
					event.setCancelled(true);
				}
			}
		}
	}
}