package com.todomaker.todomakerserver.controller;

import com.todomaker.todomakerserver.dto.TodoDTO;
import com.todomaker.todomakerserver.entity.TodoEntity;
import com.todomaker.todomakerserver.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return new ResponseEntity<>(
                todoService.getAll(),
                HttpStatus.OK
        );
    }
}
