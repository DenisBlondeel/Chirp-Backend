package me.chirp.controller;

import me.chirp.model.Role;
import me.chirp.model.UserDTO;
import me.chirp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @GetMapping("/role/{id}/{role}")
    public ResponseEntity addRoleToUser(@PathVariable UUID id, @PathVariable String role){
       return userService.addRole(id, role);
    }

    @DeleteMapping("/role/{id}/{role}")
    public void removeRoleToUser(@PathVariable UUID id, @PathVariable String role){
        userService.removeRole(id, role);
    }
}
