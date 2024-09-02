package io.github.nazarovctrl.telegrambotspring.context;

import org.telegram.telegrambots.meta.api.objects.User;

public class UserContext {
    private static final ThreadLocal<User> userContext = new ThreadLocal<>();

    public static void setUser(User userInfo) {
        userContext.set(userInfo);
    }

    public static User getUser() {
        return userContext.get();
    }

    public static void clear() {
        userContext.remove();
    }
}
