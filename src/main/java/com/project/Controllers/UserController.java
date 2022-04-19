package com.project.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import com.project.Models.User;
import com.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path="/{id}")
    public Optional<User> getUserById(@PathParam("id") Long id) {
            return this.userService.getById(id);
    }

    @GetMapping("/query")
    public List<User> getUsersByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getByPriority(priority);
    }

    @DeleteMapping (path="/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "The user with id " + id + " has been deleted.";
        } else {
            return "The user with id " + id + " could not be deleted.";
        }
    }
    
}
