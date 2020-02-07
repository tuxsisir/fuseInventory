package com.fuse.fuseinventory.controller;

import com.fuse.fuseinventory.exception.ResourceNotFoundException;
import com.fuse.fuseinventory.model.UserModel;
import com.fuse.fuseinventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Page<UserModel> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @PostMapping("/user")
    public UserModel createUser(@Valid @RequestBody UserModel user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{userId}")
    public UserModel updatUser(@PathVariable Long userId,
                                   @Valid @RequestBody UserModel userRequest) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setFullName(userRequest.getFullName());
                    user.setEmail(userRequest.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("Bad Request! User Not Found."));
    }


    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User Not Found."));
    }
}