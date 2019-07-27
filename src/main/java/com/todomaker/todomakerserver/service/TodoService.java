package com.todomaker.todomakerserver.service;

import com.todomaker.todomakerserver.dto.TodoDTO;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
public interface TodoService {

    List<TodoDTO> getAll();

    TodoDTO getById(Long todoId) throws Exception;

    Long save(TodoDTO todoDTO) throws Exception;

    void update(TodoDTO todoDTO) throws Exception;

    void delete(TodoDTO todoDTO) throws Exception;

    void deleteById(Long todoId) throws Exception;
}
