package com.sample.firstapplication.service;

import com.sample.firstapplication.entity.User;
import com.sample.firstapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers(String sortBy, Integer pageNo, Integer pageSize) {
        //return (List<User>) userRepository.findAll();
       Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<User> pagedResult = userRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }else{
            return new ArrayList<User>();
        }
    }

    public void postDetails(User user) {
    Optional<User> userInDB = userRepository.findById(user.getId());
    if (userInDB.isEmpty()) {
        userRepository.save(user);
    }
    }


}
