package com.joy.demo.repository;

import com.joy.demo.domain.hash.UserHash;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRedisRepository extends CrudRepository<UserHash, Long> {
    Optional<UserHash> findUserByName(String name);
}
