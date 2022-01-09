package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.User;
import com.jwt.test.demo.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for userRepo")
class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    @DisplayName("Save creates user when successful")
    void save_PresistUser_WhenSuccessful(){
        User userToBeSaved = createUser();
        User userSaved = this.userRepo.save(userToBeSaved);
        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getUsername()).isEqualTo(userToBeSaved.getUsername());

    }

    @Test
    @DisplayName("findByName finds user by its username")
    void findByName_ReturnsUser_WhenSuccessful(){
        User userToBeSaved = createUser();
        this.userRepo.save(userToBeSaved);
        User userSaved = this.userRepo.findByUsername(userToBeSaved.getUsername());
        Assertions.assertThat(userToBeSaved.getUsername()).isEqualTo(userSaved.getUsername());
    }

    @Test
    @DisplayName("findAll returns a list of users when successful")
    void findAll_ReturnsListOffUsers_WhenSuccessful(){
        User userToBeSaved = createUser();
        this.userRepo.save(userToBeSaved);
        List<User> userList = this.userRepo.findAll();
        Assertions.assertThat(userList).isNotNull();
    }

    private User createUser(){
        return User.builder()
                .username("Pelosi")
                .password("1234")
                .name("João Pedro Pelosi")
                .build();
    }

}