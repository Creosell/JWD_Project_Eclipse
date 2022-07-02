package by.sheshko.shop.controller;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1407153927071641240L;

    public ControllerException() {
    }

    public ControllerException(final String message) {
        super(message);
    }

    public ControllerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ControllerException(final Throwable cause) {
        super(cause);
    }
}
