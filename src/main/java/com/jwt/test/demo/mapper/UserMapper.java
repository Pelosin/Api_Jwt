package com.jwt.test.demo.mapper;

import com.jwt.test.demo.domain.User;
import com.jwt.test.demo.payload.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class UserMapper {
    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();

    }
}
