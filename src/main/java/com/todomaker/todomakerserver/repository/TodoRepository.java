package com.todomaker.todomakerserver.repository;

import com.todomaker.todomakerserver.entity.TodoEntity;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
public interface TodoRepository {

    List<TodoEntity> findAll();
}
