package org.example.api.controller;

import org.example.api.model.User;
import org.example.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepo;


    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user){
        try {
            userRepo.save(user);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

}
