package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateDTO;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Retrieve all users.
     * @return List of all users.
     */
    @GetMapping
    public List<User> getAllUsers() { return userService.findAll(); }

    /**
     * Retrieve a user by ID.
     * @param id User ID.
     * @return User details if found.
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) { return userService.findById(id); }

    /**
     * Create a new user.
     * @param user User object.
     * @return The created user.
     */
    @PostMapping
    public User createUser(@RequestBody UserDTO user) { return userService.save(user); }

    /**
     * Update an existent user.
     * @param user User object.
     * @return The updated user.
     */
    @PutMapping
    public User updateUser(@RequestBody UserUpdateDTO user) { return userService.save(user); }

    /**
     * Delete a user by ID.
     * @param id User ID.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteById(id); }
}

