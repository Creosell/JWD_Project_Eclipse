package by.sheshko.shop.dao.pool.exception;

public class ConnectionPoolException extends Exception{

    private static final long serialVersionUID = -4855382071380067490L;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
