package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by yingu on 2016/11/14.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate created;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public User setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.created = LocalDate.now();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
