package com.vnext.interjava.userproduct.idea.service;

import com.vnext.interjava.userproduct.idea.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();
    void saveUser(User user);
    void deleteUser(Long id);
    Optional<User> findUserById(Long id);



}
