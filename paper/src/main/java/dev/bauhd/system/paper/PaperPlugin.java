package dev.bauhd.system.paper;

import dev.bauhd.system.common.Plugin;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPlugin extends JavaPlugin implements Plugin {

  @Override
  public void onEnable() {

  }

  @Override
  public CommandMap commandMap() {
    return this.getServer().getCommandMap();
  }
}
