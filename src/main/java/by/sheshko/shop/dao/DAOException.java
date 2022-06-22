package by.sheshko.shop.dao;

public class DAOException extends Exception{
    private static final long serialVersionUID = 4598052794997576535L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
