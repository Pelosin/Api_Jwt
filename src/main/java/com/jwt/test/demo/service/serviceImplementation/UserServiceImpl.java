package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Role;
import com.jwt.test.demo.domain.User;
import com.jwt.test.demo.exception.BadRequestException;
import com.jwt.test.demo.repo.RoleRepo;
import com.jwt.test.demo.repo.UserRepo;
import com.jwt.test.demo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class UserServiceImpl implements UserService, UserDetailsService {

    private final @NonNull UserRepo userRepo;
    private final @NonNull RoleRepo roleRepo;
    private final @NonNull PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            log.error("User not found at database");
            throw new UsernameNotFoundException("User not found at database");
        }else{
            log.info("User found at database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {}", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(roleRepo.findByName("ROLE_USER"));

        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRole(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUserByUsername(String username) {
        User userByUsername = userRepo.findByUsername(username);
        if (userByUsername == null){
            throw new BadRequestException("User " + username + " not found at DB");
        }
        log.info("Fetching user {}", username);
        return userByUsername;
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all user");
        return userRepo.findAll();
    }

    @Override
    public User createAdminUser() {
        Collection<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findByName("ROLE_ADMIN"));
        log.info("Creating admin user");

        return userRepo.save(User.builder()
                .name("admin")
                .username("USER_ADMIN")
                .password(passwordEncoder.encode("1234"))
                .roles(roles)
                .build());

    }

}
