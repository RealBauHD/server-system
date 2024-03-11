package dev.bauhd.system.legacy;

import dev.bauhd.system.common.Plugin;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public class LegacyPlugin extends JavaPlugin implements Plugin {

  @Override
  public void onEnable() {

  }

  @Override
  public CommandMap commandMap() {
    try {
      return (CommandMap) this.getServer().getClass()
              .getMethod("getCommandMap")
              .invoke(this.getServer());
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
