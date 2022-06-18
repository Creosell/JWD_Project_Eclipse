package by.sheshko.shop.dao.pool;

import by.sheshko.shop.dao.DBResourceManager;
import by.sheshko.shop.dao.pool.exception.ConnectionPoolException;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {

    private BlockingQueue<Connection> connectionsQueue;
    private BlockingQueue<Connection> givenAwayQueue;

    private String driverName;
    private String url;
    private String userName;
    private String password;
    private int poolSize;

    private ConnectionPool(){
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.userName = dbResourceManager.getValue(DBParameter.DB_USERNAME);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        try{
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOLSIZE));
        }catch (NumberFormatException e){
            this.poolSize = 5;
        }
    }

    public void initPoolData() throws ConnectionPoolException {
        try{
            Class.forName(driverName);
            givenAwayQueue = new ArrayBlockingQueue<>(poolSize, true);
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Error while trying to find driver class",e);
        }
    }
}
