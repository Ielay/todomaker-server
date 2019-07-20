package com.todomaker.todomakerserver.repository;

import com.todomaker.todomakerserver.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author petrov
 * @since 20.07.19
 */
@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final List<TodoEntity> inMemoryStorage = new ArrayList<>(3);

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
            todo.setTodoDay((LocalDate) params.get(2));

            inMemoryStorage.add(todo);
        });
    }

    @Override
    public List<TodoEntity> findAll() {
        return new ArrayList<>(inMemoryStorage);
    }
}
