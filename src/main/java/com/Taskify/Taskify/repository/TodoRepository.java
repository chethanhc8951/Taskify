package com.Taskify.Taskify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Taskify.Taskify.model.Todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TodoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create todo
    public void save(Todo todo) {

        entityManager.persist(todo);

    }

    // find all todo list

    public List<Todo> findTodoList() {

        return entityManager.createQuery("From Todo", Todo.class).getResultList();
    }

    // find todo by id
    public Optional<Todo> findById(Long id) {

        return Optional.ofNullable(entityManager.find(Todo.class, id));
    }

    // delete todo by id
    public void deleteById(Long id) {

        Todo todo = entityManager.find(Todo.class, id);
        if (todo != null) {
            entityManager.remove(todo);
        } 
    }

}
