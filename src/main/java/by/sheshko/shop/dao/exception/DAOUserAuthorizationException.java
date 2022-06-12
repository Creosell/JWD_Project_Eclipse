package by.sheshko.shop.dao.exception;

public class DAOUserAuthorizationException extends Exception{
    public DAOUserAuthorizationException() {
    }

    public DAOUserAuthorizationException(String message) {
        super(message);
    }

    public DAOUserAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOUserAuthorizationException(Throwable cause) {
        super(cause);
    }
}
