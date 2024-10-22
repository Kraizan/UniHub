package com.kraizan.userms.user;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    boolean createUser(User user);
    User getUserById(Long id);
    boolean updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);
}
