package com.example.web;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yingu on 2016/11/14.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

/*    @GetMapping("/users")
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }*/

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, User user) {
        return userRepository.save(user); //TODO: merge
    }

    @GetMapping("/users")
    public List<User> findUsers(@RequestParam(defaultValue = "") String name) {
        return userRepository.findByNameLike("%" + name + "%");
    }

    // ...
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        System.out.println("UserController.getUser");
//        return user;
//        User user2 = userService.findUser(id);
//        System.out.println("user2 = " + user2);
        User user = userRepository.findOne(id);
        System.out.println("user = [" + user + "]");
        return user;
    }

}
