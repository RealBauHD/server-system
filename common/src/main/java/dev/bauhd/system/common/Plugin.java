package dev.bauhd.system.common;

import org.bukkit.command.CommandMap;

public interface Plugin extends org.bukkit.plugin.Plugin {

  CommandMap commandMap();
}
