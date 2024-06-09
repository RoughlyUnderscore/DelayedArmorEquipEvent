package com.jeff_media.armorequipevent;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TaskUtils {
  public TaskUtils() {
    throw new IllegalStateException("Cannot initialize a static class");
  }

  public static void delayed(JavaPlugin plugin, Runnable action) {
    delayed(plugin, action, 1);
  }

  public static void delayed(JavaPlugin plugin, Runnable action, int ticks) {
    Bukkit.getScheduler().runTaskLater(plugin, action, ticks);
  }
}
