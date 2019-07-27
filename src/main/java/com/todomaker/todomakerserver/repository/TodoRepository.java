package com.todomaker.todomakerserver.repository;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.todomaker.todomakerserver.entity.TodoEntity;

import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
public interface TodoRepository {

    @NotNull
    List<TodoEntity> findAll();

    @Nullable
    TodoEntity findById(Long todoId);

    @Nullable
    Long save(TodoEntity savedEntity);

    @Nullable
    TodoEntity update(TodoEntity updatedEntity);

    @Nullable
    Long delete(TodoEntity deletedEntity);

    @Nullable
    Long deleteById(Long todoId);
}
