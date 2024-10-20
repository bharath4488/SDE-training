package com.basics.amazon.learnSpringBoot.service.impl;

import com.basics.amazon.learnSpringBoot.dto.UserDTO;
import com.basics.amazon.learnSpringBoot.exception.user.UserExceptions;
import com.basics.amazon.learnSpringBoot.mapper.GenericMapper;
import com.basics.amazon.learnSpringBoot.model.User;
import com.basics.amazon.learnSpringBoot.repository.UserRepository;
import com.basics.amazon.learnSpringBoot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(User user) throws UserExceptions.EmptyUserDetailsException, IllegalAccessException {
        if (user == null) throw new UserExceptions.EmptyUserDetailsException("Cannot save empty payload");

        Field[] userFields = User.class.getDeclaredFields();

        for (Field field : userFields) {
            if(field == null) continue;
            if(field.getName().equals("id")) continue;

            field.setAccessible(true);
            Object value = field.get(user);
            if (value == null) throw new UserExceptions.EmptyUserDetailsException("Property '" + field.getName() + "' is null");
        }
        User savedUser = this.userRepository.saveAndFlush(user);
        return GenericMapper.entityToDto(savedUser, UserDTO.class);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
