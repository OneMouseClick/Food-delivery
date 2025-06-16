package delivery.classes;

import delivery.interfaces.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User register(String username, String password) {
        User user = new User(username, password, Role.USER);
        users.put(username, user);
        return user;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
