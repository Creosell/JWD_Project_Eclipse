package by.sheshko.shop.service;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 4375740058776526848L;

    public ServiceException() {
    }

    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServiceException(final Throwable cause) {
        super(cause);
    }
}
