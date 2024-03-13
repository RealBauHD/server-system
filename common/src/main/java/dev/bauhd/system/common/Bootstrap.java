package dev.bauhd.system.common;

import dev.bauhd.system.common.user.UserManager;
import dev.bauhd.system.common.user.UserProvider;
import java.util.ResourceBundle;

public final class Bootstrap {

  private final Plugin plugin;
  private final UserManager userManager;
  private final boolean legacy;
  private final ResourceBundle resourceBundle;

  public Bootstrap(final Plugin plugin, final UserProvider userProvider, final boolean legacy) {
    this.plugin = plugin;
    this.userManager = new UserManager(userProvider);
    this.legacy = legacy;

    this.plugin.getServer().getPluginManager().registerEvents(this.userManager, this.plugin);
    this.resourceBundle = ResourceBundle.getBundle("messages");
  }

  public boolean check() {
    final boolean miniMessage = this.hasMiniMessage();
    if (!miniMessage && !this.legacy) {
      this.plugin.getLogger().severe(
          "[Server-System] The plugin can't start without a software that ships mini message!");
      this.plugin.getLogger().severe(
          "[Server-System] Please try the legacy version of this plugin.");
      return true;
    }

    if (miniMessage && this.legacy) {
      this.plugin.getLogger().warning(
          "[Server-System] You can upgrade to the paper version of this plugin to save some performance."
      );
    }
    return false;
  }

  private boolean hasMiniMessage() {
    try {
      Class.forName("net-kyori-adventure.text.minimessage.MiniMessage"
          .replace('-', '.')); // avoid relocation here
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

  public Plugin plugin() {
    return this.plugin;
  }

  public ResourceBundle resourceBundle() {
    return this.resourceBundle;
  }
}
