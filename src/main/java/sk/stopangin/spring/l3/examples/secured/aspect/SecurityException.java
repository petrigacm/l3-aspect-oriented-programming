package sk.stopangin.spring.l3.examples.secured.aspect;

public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super(message);
    }
}
