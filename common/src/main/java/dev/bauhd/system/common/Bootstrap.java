package dev.bauhd.system.common;

import dev.bauhd.system.common.user.UserManager;
import dev.bauhd.system.common.user.UserProvider;

public final class Bootstrap {

  private final Plugin plugin;
  private final UserManager userManager;
  private final boolean legacy;

  public Bootstrap(final Plugin plugin, final UserProvider userProvider, final boolean legacy) {
    this.plugin = plugin;
    this.userManager = new UserManager(userProvider);
    this.legacy = legacy;
  }

  public void check() {
    final boolean miniMessage = this.hasMiniMessage();
    if (!miniMessage && !this.legacy) {
      this.plugin.logger().severe(
          "[Server-System] The plugin can't start without a software that ships mini message!");
      this.plugin.logger().severe(
          "[Server-System] Please try the legacy version of this plugin.");
      return;
    }

    if (miniMessage && this.legacy) {
      this.plugin.logger().info(
          "[Server-System] You can upgrade to the paper version of this plugin to save some performance."
      );
    }
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
}
