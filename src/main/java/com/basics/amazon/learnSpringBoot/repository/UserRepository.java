package com.basics.amazon.learnSpringBoot.repository;

import com.basics.amazon.learnSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User saveAndFlush(User user);
    public User save(User user);
    public List<User> findAll();

}
