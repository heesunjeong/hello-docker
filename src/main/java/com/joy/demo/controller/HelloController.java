package com.joy.demo.controller;

import com.joy.demo.domain.User;
import com.joy.demo.domain.hash.UserHash;
import com.joy.demo.repository.UserRedisRepository;
import com.joy.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final UserRepository userRepository;
    private final UserRedisRepository userRedisRepository;

    public HelloController(UserRepository userRepository, UserRedisRepository userRedisRepository) {
        this.userRepository = userRepository;
        this.userRedisRepository = userRedisRepository;
    }

    @GetMapping
    public String sayHello() {
        return "Hello World!!!";
    }

    @GetMapping("/{name}")
    public String sayYourName(@PathVariable String name) {
        String userName = userRedisRepository.findUserByName(name)
                .map(UserHash::getName)
                .orElseGet(() -> {
                    User savedUser = userRepository.save(User.builder().name(name).build());
                    userRedisRepository.save(UserHash.of(savedUser));
                    return savedUser.getName();
                });

        return String.format("Hello %s", userName);
    }
}
