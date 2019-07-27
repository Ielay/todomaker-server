package com.todomaker.todomakerserver.service;

import com.todomaker.todomakerserver.dto.TodoDTO;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
public interface TodoService {

    List<TodoDTO> getAll();
}
