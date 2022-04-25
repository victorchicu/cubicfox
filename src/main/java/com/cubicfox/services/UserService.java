package com.cubicfox.services;

import com.cubicfox.domain.User;

import java.util.List;

public interface UserService {
    void saveAll(List<User> users);
    User saveOrUpdate(User user);
    List<User> findAll();
}
