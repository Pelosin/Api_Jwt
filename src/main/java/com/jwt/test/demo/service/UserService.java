package com.jwt.test.demo.service;

import java.util.List;
import com.jwt.test.demo.domain.Role;
import com.jwt.test.demo.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRole (String username, String roleName);
    User getUser (String username);
    List<User> getUsers();
}
