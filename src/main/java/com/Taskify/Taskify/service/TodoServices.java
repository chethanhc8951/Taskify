package com.Taskify.Taskify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Taskify.Taskify.model.Todo;
import com.Taskify.Taskify.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServices {

    private final TodoRepository todoRepository;


    //create 

    public void createTodo(Todo todo) {

        todoRepository.save(todo);
    }


//find all todo

    public List<Todo> getAllTodos() {

        return todoRepository.findTodoList();
    }


    // get todo by id

    public Todo getTodoById(Long id) {

        return todoRepository.findById(id).orElse(null);
    }

    // delete todo by id

    public void deleteTodo(Long id) {

        todoRepository.deleteById(id);
    }


    // update
    public void updateTodo(Long id, Todo todo) {
        todoRepository.findById(id).ifPresent(existingTodo -> {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setDate(todo.getDate());
            existingTodo.setReminderTime(todo.getReminderTime());
            todoRepository.save(existingTodo);
        });
    }

}
