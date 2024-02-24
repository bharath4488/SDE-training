package com.basics.amazon.learnSpringBoot.controller;

import com.basics.amazon.learnSpringBoot.exception.user.UserExceptions;
import com.basics.amazon.learnSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basics.amazon.learnSpringBoot.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) throws UserExceptions.EmptyUserDetailsException, IllegalAccessException {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.userService.save(user));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.userService.getAllUsers());
    }

}
