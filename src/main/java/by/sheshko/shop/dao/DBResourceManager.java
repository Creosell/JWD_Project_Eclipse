package by.sheshko.shop.dao;

import java.util.Objects;
import java.util.ResourceBundle;

public class DBResourceManager {
    private static final DBResourceManager instance = new DBResourceManager();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public static DBResourceManager getInstance() {
        return instance;
    }
    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
