package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Role;
import com.jwt.test.demo.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for roleRepo")
class RoleRepoTest {
    @Autowired
    private RoleRepo roleRepo;

    @Test
    @DisplayName("Save persist role when successful")
    public void save_PersistRole_WhenSuccessful(){
        Role roleToBeSaved = createRole();
        Role savedRole = roleRepo.save(roleToBeSaved);
        Assertions.assertThat(savedRole).isNotNull();
        Assertions.assertThat(roleToBeSaved.getId()).isEqualTo(savedRole.getId());
    }


    public Role createRole(){
        return Role.builder()
                .name("ROLE_USER")
                .build();
    }

    private User createUser(){
        return User.builder()
                .username("Pelosi")
                .password("1234")
                .name("João Pedro Pelosi")
                .build();
    }

}