package com.curdcuboverde.service;

import com.curdcuboverde.entity.User;
import com.curdcuboverde.repository.RoleRepository;
import com.curdcuboverde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getUsers(){

        return userRepository.findAll();
    }
    public Optional<User> getUser(Long id){

        return userRepository.findById(id);
    }

    public void saveOrUpdate(User user){
        if (roleRepository.findById(user.getIdRol()).isPresent()) {
            System.out.println(user);
            userRepository.save(user);
        }
        else {
            return;
        }
    }

    public Optional<User> update(Long id, User userModel){
        if (roleRepository.findById(userModel.getIdRol()).isPresent()) {
            User updateUserModel = userRepository.findById(id).get();
            updateUserModel.setFistName(userModel.getFistName());
            updateUserModel.setLastName(userModel.getLastName());
            updateUserModel.setPhone(userModel.getPhone());
            updateUserModel.setEmail(userModel.getEmail());
            updateUserModel.setIdRol(userModel.getIdRol());
            updateUserModel.setUserPassword(userModel.getUserPassword());
            userRepository.save(updateUserModel);

            return userRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public void delete(Long id){

        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String emailU) {
        return userRepository.findByEmail(emailU);
    }
}
