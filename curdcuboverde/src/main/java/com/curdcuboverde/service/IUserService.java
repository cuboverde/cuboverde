package com.curdcuboverde.service;

import com.curdcuboverde.entity.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByEmail(String email);
}
