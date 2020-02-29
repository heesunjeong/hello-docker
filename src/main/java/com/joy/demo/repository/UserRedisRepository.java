package com.joy.demo.repository;

import com.joy.demo.domain.redis.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRedisRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByName(String name);
}
