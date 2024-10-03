package com.example.deliveryService.controller;

import com.example.deliveryService.model.User;
import com.example.deliveryService.service.UserService;
import io.github.bucket4j.Bucket;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Bucket bucket;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        if (bucket.tryConsume(1)) { // Rate limit
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.status(429).build();
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
