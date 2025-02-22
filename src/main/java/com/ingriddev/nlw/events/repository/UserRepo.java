package com.ingriddev.nlw.events.repository;

import com.ingriddev.nlw.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
