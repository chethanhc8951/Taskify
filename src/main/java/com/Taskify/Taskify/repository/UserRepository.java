package com.Taskify.Taskify.repository;

import org.springframework.stereotype.Repository;

import com.Taskify.Taskify.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create todo
    public void save(User user) {

        entityManager.persist(user);

    }

    public User findByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
