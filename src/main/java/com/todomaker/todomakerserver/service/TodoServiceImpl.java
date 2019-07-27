package com.todomaker.todomakerserver.service;

import com.todomaker.todomakerserver.dto.TodoDTO;
import com.todomaker.todomakerserver.entity.TodoEntity;
import com.todomaker.todomakerserver.mapper.TodoMapper;
import com.todomaker.todomakerserver.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private TodoMapper todoMapper;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoEntity> todoEntities = todoRepository.findAll();

        List<TodoDTO> todoDtos = todoMapper.toDto(todoEntities);

        log.debug("Got {} todos", todoDtos.size());

        return todoDtos;
    }
}
