package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yingu on 2016/11/14.
 */
//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameLike(String name);
}
