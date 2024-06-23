package com.curdcuboverde.service;

import com.curdcuboverde.entity.User;
import com.curdcuboverde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public void saveOrUpdate(User user){
        System.out.println(user);
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

}
