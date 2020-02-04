package com.sample.firstapplication.repository;

import com.sample.firstapplication.entity.User;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsersLike() {
        //TypedQuery<User> query = entityManager.createQuery("select u from User u where u.surname like"+"'"+firstname+"%"+"'" , User.class);
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);


        return query.getResultList();
    }
}

