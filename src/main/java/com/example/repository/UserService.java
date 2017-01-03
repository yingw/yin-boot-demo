package com.example.repository;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yingu on 2016/10/30.
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @CachePut(key = "'user_'+#user.id")
    public User createOrUpdateUser(User user) {
        System.out.println("UserService.createOrUpdateUser");
        return userRepository.save(user);
    }

    @Cacheable(key = "'user_'+#userId")
    public User findUser(Long userId) {
        System.out.println("UserService.findUser");
        return userRepository.findOne(userId);
    }

    @CacheEvict(key = "'user_'+#userId")
    public void deleteUser(Long userId) {
        System.out.println("UserService.deleteUser");
        userRepository.delete(userId);
    }
}
