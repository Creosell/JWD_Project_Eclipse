package by.sheshko.shop.controller;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1407153927071641240L;

    public ControllerException() {
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
