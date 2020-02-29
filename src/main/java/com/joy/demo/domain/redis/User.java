package com.joy.demo.domain.redis;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("user")
public class User {
    @Id
    private Long id;
    private String name;

    public String getName() {
        return this.name;
    }
}
