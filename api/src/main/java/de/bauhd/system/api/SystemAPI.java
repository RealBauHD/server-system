package de.bauhd.system.api;

import de.bauhd.system.api.money.MoneyHandler;
import de.bauhd.system.api.user.UserHandler;

public abstract class SystemAPI {

    public static SystemAPI instance;

    public static void setInstance(final SystemAPI instance) {
        SystemAPI.instance = instance;
    }

    public static SystemAPI getInstance() {
        return instance;
    }

    /**
     * @return the instance of the money handler
     */
    public abstract MoneyHandler getMoneyHandler();

    /**
     * @return the instance of the user handler
     */
    public abstract UserHandler getUserHandler();

}
