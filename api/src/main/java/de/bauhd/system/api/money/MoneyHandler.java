package de.bauhd.system.api.money;

import de.bauhd.system.api.user.User;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MoneyHandler {

    /**
     * @param uuid the uuid to get the money
     * @return the money
     */
    int getMoney(final @NotNull UUID uuid);

    /**
     * @param iUser the user to get the money
     * @return the money
     */
    int getMoney(final @NotNull User iUser);

    /**
     * @param uuid the uuid to set the money
     * @param money the money to set
     */
    void setMoney(final @NotNull UUID uuid, final int money);

    /**
     * @param iUser the user to set the money
     * @param money the money to set
     */
    void setMoney(final @NotNull User iUser, final int money);

    /**
     * @param uuid the uuid to add the money
     * @param money the money to set
     */
    void addMoney(final @NotNull UUID uuid, final int money);

    /**
     * @param iUser the user to add the money
     * @param money the money to set
     */
    void addMoney(final @NotNull User iUser, final int money);

    /**
     * @param uuid the uuid to add the money
     * @param money the money to set
     */
    void removeMoney(final @NotNull UUID uuid, final int money);

    /**
     * @param iUser the user to remove the money
     * @param money the money to set
     */
    void removeMoney(final @NotNull User iUser, final int money);

}
