package dev.bauhd.system.paper.user;

import dev.bauhd.system.common.user.User;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public final class PaperUser implements User {

  private final Player player;

  public PaperUser(final Player player) {
    this.player = player;
  }

  @Override
  public Player player() {
    return this.player;
  }

  @Override
  public void sendMessage(String message) {
    this.player.sendMessage(MiniMessage.miniMessage().deserialize(message));
  }
}
