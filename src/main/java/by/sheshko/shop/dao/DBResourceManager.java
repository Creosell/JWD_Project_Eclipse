package by.sheshko.shop.dao;

import java.util.ResourceBundle;

public final class DBResourceManager {
    private static final DBResourceManager INSTANCE = new DBResourceManager();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public static DBResourceManager getInstance() {
        synchronized (DBResourceManager.class) {
            return INSTANCE;
        }
    }

    public String getValue(final String key) {
        return resourceBundle.getString(key);
    }
}
