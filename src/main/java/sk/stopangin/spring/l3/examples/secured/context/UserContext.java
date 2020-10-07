package sk.stopangin.spring.l3.examples.secured.context;

public class UserContext {
    public static final ThreadLocal<String> userContext = new InheritableThreadLocal<>();

    public static String getUsername() {
        return userContext.get();
    }

    public static void setUsername(String username) {
        userContext.set(username);
    }
}
