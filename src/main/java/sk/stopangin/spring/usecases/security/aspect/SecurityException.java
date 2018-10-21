package sk.stopangin.spring.usecases.security.aspect;

public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super(message);
    }
}
