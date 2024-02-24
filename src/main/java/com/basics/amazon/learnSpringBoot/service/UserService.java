package com.basics.amazon.learnSpringBoot.service;

import com.basics.amazon.learnSpringBoot.dto.UserDTO;
import com.basics.amazon.learnSpringBoot.exception.user.UserExceptions;
import com.basics.amazon.learnSpringBoot.model.User;

import java.util.List;

public interface UserService {

    UserDTO save(User user) throws UserExceptions.EmptyUserDetailsException, IllegalAccessException;
    List<User> getAllUsers();

}
