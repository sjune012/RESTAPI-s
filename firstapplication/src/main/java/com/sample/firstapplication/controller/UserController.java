package com.sample.firstapplication.controller;

import com.sample.firstapplication.entity.User;
import com.sample.firstapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> findUsers(@RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
       return userService.findUsers(sortBy, pageNo, pageSize);
    }

    @PostMapping("/user/request")
    public ResponseEntity postUser(@RequestBody User user) {
        userService.postDetails(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
