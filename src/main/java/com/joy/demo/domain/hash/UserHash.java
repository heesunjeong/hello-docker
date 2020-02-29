package com.joy.demo.domain.hash;

import com.joy.demo.domain.User;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@RedisHash("user")
public class UserHash {
    @Id
    private Long id;

    @Indexed
    private String name;

    @Builder
    public UserHash(String name) {
        this.name = name;
    }

    public static UserHash of(User user) {
        return UserHash.builder()
                .name(user.getName())
                .build();
    }
}
