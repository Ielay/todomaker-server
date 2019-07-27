package com.todomaker.todomakerserver.controller;

import com.todomaker.todomakerserver.dto.TodoDTO;
import com.todomaker.todomakerserver.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/todos/{todo_id}")
    public ResponseEntity<TodoDTO> getById(@PathVariable(name = "todo_id") Long todoId) throws Exception {
        return new ResponseEntity<>(
                todoService.getById(todoId),
                HttpStatus.OK
        );
    }

    @PostMapping("/todos")
    public ResponseEntity<Long> addNewTodo(@RequestBody TodoDTO newTodo) throws Exception {
        return new ResponseEntity<>(
                todoService.save(newTodo),
                HttpStatus.OK
        );
    }

    @PutMapping("/todos")
    public ResponseEntity updateTodo(@RequestBody TodoDTO updatedTodo) throws Exception {
        todoService.update(updatedTodo);

        return new ResponseEntity(
                HttpStatus.OK
        );
    }

    @DeleteMapping("/todos/{todo_id}")
    public ResponseEntity deleteById(@PathVariable(name = "todo_id") Long todoId) throws Exception {
        todoService.deleteById(todoId);

        return new ResponseEntity(
                HttpStatus.OK
        );
    }
}
