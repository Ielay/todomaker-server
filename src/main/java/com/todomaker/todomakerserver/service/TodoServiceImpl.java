package com.todomaker.todomakerserver.service;

import com.todomaker.todomakerserver.entity.TodoEntity;
import com.todomaker.todomakerserver.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoEntity> getAll() {
        return todoRepository.findAll();
    }
}
