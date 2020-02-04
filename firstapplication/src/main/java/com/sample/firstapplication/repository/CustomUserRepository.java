package com.sample.firstapplication.repository;

import com.sample.firstapplication.entity.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> getUsersLike();
}
