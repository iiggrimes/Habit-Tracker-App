package com.dev.habittracker.controllers;

import com.dev.habittracker.models.User;
import com.dev.habittracker.repositories.UserRepository;
import com.dev.habittracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username)); //hard to warp
        return userOptional.map(user -> ResponseEntity.ok().body(user)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getUsername())).body(savedUser);

    }





/*    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));

    }*/
}
