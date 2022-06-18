package by.sheshko.shop.dao.pool;

public class DBParameter {

    private DBParameter(){}

    public static final String DB_DRIVER = "jdbc.driver=com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc.url=jdbc:mysql://127.0.0.1/JWD_ShopDB?useSSL=false";
    public static final String DB_USERNAME = "jdbc.username=root";
    public static final String DB_PASSWORD = "jdbc.password=admin";
    public static final String DB_POOLSIZE = "jdbc.poolsize = 5";
}
