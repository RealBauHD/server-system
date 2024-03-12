package dev.bauhd.system.common.user;

import org.bukkit.entity.Player;

public interface User {

  Player player();

  void sendMessage(String message);
}
