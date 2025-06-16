package delivery;

import delivery.classes.User;
import delivery.classes.UserServiceImpl;
import delivery.interfaces.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        User user = userService.register("Dmitriy", "password123");
        System.out.println("Пользователь зарегистрирован: " + user);

        boolean isAuthenticated = userService.authenticate("Dmitriy", "password123");
        System.out.println("Аутентификация прошла успешно: " + isAuthenticated);
    }
}