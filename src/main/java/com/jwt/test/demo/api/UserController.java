package com.jwt.test.demo.api;

import com.jwt.test.demo.config.security.JwtUtil;
import com.jwt.test.demo.domain.Role;
import com.jwt.test.demo.domain.User;
import com.jwt.test.demo.exception.InvalidCredentialsException;
import com.jwt.test.demo.payload.request.UserRequest;
import com.jwt.test.demo.payload.response.AuthenticationResponse;
import com.jwt.test.demo.service.UserService;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "**")
public class UserController {
    private final @NonNull UserService userService;
    private final @NonNull AuthenticationManager authenticationManager;
    private final @NonNull JwtUtil jwtUtil;

    @GetMapping("/test")
    public ResponseEntity<Void> testJwtToken(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody UserRequest userRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
            );
            log.info("trying to log {} {}", userRequest.getUsername(), userRequest.getPassword());
            return ResponseEntity.ok().body(new AuthenticationResponse(jwtUtil.generateToken(userRequest.getUsername())));

        } catch (Exception e) {
            throw new InvalidCredentialsException("Invalid username or password" + e.getMessage());
        }

    }

    @PostMapping("/user/save")
    public ResponseEntity<AuthenticationResponse> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.created(uri).body(new AuthenticationResponse(jwtUtil.generateToken(user.getUsername())));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRole(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @GetMapping("/token/user")
    public ResponseEntity<User> getUserByToken(@RequestHeader(AUTHORIZATION) String jwtToken) {
        String tokenWithoutBearer = jwtToken.substring(7);
        String username = jwtUtil.extractUsername(tokenWithoutBearer);
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
