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

    @GetMapping("/login/{Email}")
    public Optional<User> LoginByEmail(@PathVariable("Email") String email){

        return userService.findByEmail(email);
    }


    @PostMapping
    public Optional<User> saveUpdate (@RequestBody User user){
        userService.saveOrUpdate(user);
        return userService.getUser(user.getIdUser());
    }

    @PutMapping("Modificar/{id}")
    public Optional<User> update(@PathVariable("id") Long id, @RequestBody  User usermodel){
        userService.update(id, usermodel);
        return userService.getUser(id);
    }

    @DeleteMapping("/{IdUser}")
    public void delete(@PathVariable("IdUser") Long IdUser){

        userService.delete(IdUser);
    }
}
