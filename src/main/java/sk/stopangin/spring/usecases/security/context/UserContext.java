package sk.stopangin.spring.usecases.security.context;

public class UserContext {
    public static final ThreadLocal<String> userContext = new InheritableThreadLocal<>();

    public static void setUsername(String username) {
        userContext.set(username);
    }

    public static String getUsername() {
        return userContext.get();
    }
}
