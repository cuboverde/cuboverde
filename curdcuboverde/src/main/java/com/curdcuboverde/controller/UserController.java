package com.curdcuboverde.controller;

import com.curdcuboverde.entity.User;
import com.curdcuboverde.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }

    @GetMapping("/{IdUser}")
    public Optional<User> getBId(@PathVariable("IdUser") Long IdUser){
        return userService.getUser(IdUser);
    }


    @PostMapping
    public void saveUpdate (@RequestBody User user){
        userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{IdUser}")
    public void delete(@PathVariable("IdUser") Long IdUser){
        userService.delete(IdUser);
    }
}
