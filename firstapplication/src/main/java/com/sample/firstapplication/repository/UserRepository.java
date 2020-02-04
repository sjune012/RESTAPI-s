package com.sample.firstapplication.repository;

import com.sample.firstapplication.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CustomUserRepository {
}
