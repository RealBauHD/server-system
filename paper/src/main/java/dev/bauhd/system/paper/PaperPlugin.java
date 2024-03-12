package dev.bauhd.system.paper;

import dev.bauhd.system.common.Bootstrap;
import dev.bauhd.system.common.Plugin;
import dev.bauhd.system.paper.user.PaperUser;
import java.util.logging.Logger;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPlugin extends JavaPlugin implements Plugin {

  @Override
  public void onEnable() {
    final Bootstrap bootstrap = new Bootstrap(this, PaperUser::new, false);
    bootstrap.check();
  }

  @Override
  public CommandMap commandMap() {
    return this.getServer().getCommandMap();
  }

  @Override
  public Logger logger() {
    return this.getServer().getLogger();
  }
}
