package by.sheshko.shop.dao;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final DBResourceManager instance = new DBResourceManager();

    public void testMethod(){
        System.out.println( String.valueOf(this.getClass().getResource("/db.properties")));
    }
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(
            String.valueOf(this.getClass().getResource("/db")));

    public static DBResourceManager getInstance() {
        return instance;
    }
    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
