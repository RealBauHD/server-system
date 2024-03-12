package dev.bauhd.system.legacy;

import dev.bauhd.system.common.Bootstrap;
import dev.bauhd.system.common.Plugin;
import dev.bauhd.system.legacy.user.LegacyUserProvider;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public class LegacyPlugin extends JavaPlugin implements Plugin {

  private BukkitAudiences audiences;

  @Override
  public void onEnable() {
    this.audiences = BukkitAudiences.create(this);
    final Bootstrap bootstrap =
        new Bootstrap(this, new LegacyUserProvider(this.audiences), true);
    bootstrap.check();
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

  @Override
  public Logger logger() {
    return this.getServer().getLogger();
  }
}
