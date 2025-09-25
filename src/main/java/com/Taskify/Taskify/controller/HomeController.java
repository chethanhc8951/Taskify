package com.Taskify.Taskify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Taskify.Taskify.model.Todo;
import com.Taskify.Taskify.service.TodoServices;

@Controller
public class HomeController {

    @Autowired
    private TodoServices todoServices;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("todos", todoServices.getAllTodos());

        return "home";
    }

    @PostMapping("/creatework")
    public String creatework(Model model, @ModelAttribute("todo") Todo todo) {

        model.addAttribute("todo", todo);
        todoServices.createTodo(todo);
        return "redirect:/home";
    }

    @GetMapping("/addtodo")
    public String addtodo(Model model) {
        return "addtodo";
    }

    @GetMapping("/deletetodo")
    public String deleteTodo(Model model, @RequestParam("id") Long id) {
        todoServices.deleteTodo(id);
        return "redirect:/home";
    }

    // update form
    @GetMapping("/updatetodo")
    public String updateTodo(Model model, @RequestParam("id") Long id) {
        Todo todo = todoServices.getTodoById(id);
        model.addAttribute("todo", todo);
        return "updatetodo";
    }

    // handle update
    @PostMapping("/handleupdatetodo")
    public String updateTodo(@ModelAttribute("todo") Todo todo, @RequestParam("id") Long id) {
        todoServices.updateTodo(id, todo);
        return "redirect:/home";
    }

    

}
