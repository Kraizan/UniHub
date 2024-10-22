package com.kraizan.userms.user.impl;

import com.kraizan.userms.user.User;
import com.kraizan.userms.user.UserRepository;
import com.kraizan.userms.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean createUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateUser(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(updatedUser.getName());
            user.setUserProducts(updatedUser.getUserProducts());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
