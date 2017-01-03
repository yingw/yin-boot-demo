package com.example.web;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yingu on 2016/11/14.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepo;

/*    @GetMapping("/users")
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }*/

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepo.delete(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, User user) {
        return userRepo.save(user); //TODO: merge
    }

    @GetMapping("/users")
    public List<User> findUsers(@RequestParam(defaultValue = "") String name) {
        return userRepo.findByNameLike("%" + name + "%");
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) { return userRepo.getOne(id);}

}
