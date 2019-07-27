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

        log.debug("Got '{}' todos", todoDtos.size());

        return todoDtos;
    }

    @Override
    public TodoDTO getById(Long todoId) throws Exception {
        TodoEntity todoEntity = todoRepository.findById(todoId);

        if (todoEntity == null) {
            throw new Exception("There is no todo with id '" + todoId + "'");
        }

        TodoDTO todoDto = todoMapper.toDto(todoEntity);

        log.debug("Found todo by id '{}'", todoId);

        return todoDto;
    }

    @Override
    public Long save(TodoDTO todoDTO) throws Exception {
        TodoEntity todoEntity = todoMapper.toEntity(todoDTO);

        Long savedId = todoRepository.save(todoEntity);

        if (savedId == null) {
            throw new Exception("Can't save todo '" + todoDTO + "'");
        }

        log.debug("A new todo with id '{}' was saved", savedId);

        return savedId;
    }

    @Override
    public void update(TodoDTO todoDTO) throws Exception {
        TodoEntity todoEntity = todoMapper.toEntity(todoDTO);

        TodoEntity updatedTodoEntity = todoRepository.update(todoEntity);

        if (!todoEntity.equals(updatedTodoEntity)) {
            throw new Exception("Can't update todo '" + todoDTO + "'");
        }

        log.debug("A todo with id '{}' was updated", updatedTodoEntity.getId());
    }

    @Override
    public void delete(TodoDTO todoDTO) throws Exception {
        TodoEntity todoEntity = todoMapper.toEntity(todoDTO);

        Long deletedTodoId = todoRepository.delete(todoEntity);

        if (deletedTodoId == null) {
            throw new Exception("Can't delete todo '" + todoDTO + "'");
        }

        log.debug("A todo with id '{}' was deleted", deletedTodoId);
    }

    @Override
    public void deleteById(Long todoId) throws Exception {
        Long deletedTodoId = todoRepository.deleteById(todoId);

        if (deletedTodoId == null) {
            throw new Exception("Can't delete todo with id '" + todoId + "'");
        }

        log.debug("A todo with id '{}' was deleted", deletedTodoId);
    }
}
