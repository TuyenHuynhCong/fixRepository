package com.vnext.interjava.userproduct.idea.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vnext.interjava.userproduct.idea.entity.User;
import com.vnext.interjava.userproduct.idea.repository.UserRepository;
import com.vnext.interjava.userproduct.idea.service.UserService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    DataSource datasource;
    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


}
