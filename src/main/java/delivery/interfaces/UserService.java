package delivery.interfaces;

import delivery.classes.User;

public interface UserService {
    User register(String username, String password);
    boolean authenticate(String username, String password);
}
