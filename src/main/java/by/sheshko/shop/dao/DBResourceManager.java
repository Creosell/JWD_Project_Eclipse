package by.sheshko.shop.dao;

import java.util.Objects;
import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle resourceBundle = ResourceBundle.getBundle(
            Objects.requireNonNull(this.getClass().getResource("/db.properties")).getPath());

    public static DBResourceManager getInstance() {
        return instance;
    }
    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
