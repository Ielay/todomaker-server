package com.todomaker.todomakerserver.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.todomaker.todomakerserver.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

/**
 * @author petrov
 * @since 20.07.19
 */
@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Set<TodoEntity> inMemoryStorage = new HashSet<>(3);

    private Long lastUsedId = 3L;

    @Autowired
    public InMemoryTodoRepository() {
        initDummyData();
    }

    private void initDummyData() {
        List<List<?>> paramsSets = Arrays.asList(
                Arrays.asList(1L, "Buy some food", LocalDate.of(2019, 8, 21)),
                Arrays.asList(2L, "Watch some cool movie", LocalDate.now()),
                Arrays.asList(3L, "Go for a walk", LocalDate.of(2019, 8, 1))
        );

        paramsSets.forEach((params) -> {
            TodoEntity todo = new TodoEntity();
            todo.setId((Long) params.get(0));
            todo.setTodoText((String) params.get(1));
            todo.setTodoDate((LocalDate) params.get(2));
            todo.setIsCompleted(false);

            inMemoryStorage.add(todo);
        });
    }

    @NotNull
    @Override
    public List<TodoEntity> findAll() {
        return new ArrayList<>(inMemoryStorage);
    }

    @Nullable
    @Override
    public TodoEntity findById(Long todoId) {
        for (TodoEntity todo : inMemoryStorage) {
            if (todo.getId().equals(todoId)) {
                return todo;
            }
        }

        return null;
    }

    @Nullable
    @Override
    public Long save(TodoEntity savedEntity) {
        savedEntity.setId(++lastUsedId);

        boolean todoWasAdded = inMemoryStorage.add(savedEntity);

        if (!todoWasAdded) {
            return null;
        }

        return lastUsedId;
    }

    @Nullable
    @Override
    public TodoEntity update(TodoEntity updatedEntity) {
        Iterator<TodoEntity> iter = inMemoryStorage.iterator();

        boolean oldTodoWasRemoved = false;
        while (iter.hasNext()) {
            TodoEntity storagedTodo = iter.next();
            if (storagedTodo.getId().equals(updatedEntity.getId())) {
                iter.remove();

                oldTodoWasRemoved = true;
                break;
            }
        }

        if (!oldTodoWasRemoved) {
            return null;
        }

        inMemoryStorage.add(updatedEntity);

        return updatedEntity;
    }

    @Nullable
    @Override
    public Long delete(TodoEntity deletedEntity) {
        boolean todoWasRemoved = inMemoryStorage.remove(deletedEntity);

        if (todoWasRemoved) {
            return deletedEntity.getId();
        }

        return null;
    }

    @Override
    public Long deleteById(Long todoId) {
        Iterator<TodoEntity> iter = inMemoryStorage.iterator();

        boolean oldTodoWasRemoved = false;
        while (iter.hasNext()) {
            TodoEntity storagedTodo = iter.next();
            if (storagedTodo.getId().equals(todoId)) {
                iter.remove();

                oldTodoWasRemoved = true;
                break;
            }
        }

        if (!oldTodoWasRemoved) {
            return null;
        }

        return todoId;
    }
}
