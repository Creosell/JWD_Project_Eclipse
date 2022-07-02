package by.sheshko.shop.dao;

public class DAOException extends Exception {
    private static final long serialVersionUID = 4598052794997576535L;

    public DAOException() {
    }

    public DAOException(final String message) {
        super(message);
    }

    public DAOException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DAOException(final Throwable cause) {
        super(cause);
    }
}
