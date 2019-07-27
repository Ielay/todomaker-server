package com.todomaker.todomakerserver.mapper;

import com.todomaker.todomakerserver.dto.TodoDTO;
import com.todomaker.todomakerserver.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lelay
 * @since 27.07.19
 */
@Component
public class TodoMapper {

    public List<TodoDTO> toDto(List<TodoEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TodoDTO toDto(TodoEntity entity) {
        TodoDTO dto = new TodoDTO();

        dto.id = entity.getId();
        dto.todoText = entity.getTodoText();
        dto.todoDate = entity.getTodoDate();
        dto.isCompleted = entity.getIsCompleted();

        return dto;
    }

    public TodoEntity toEntity(TodoDTO dto) {
        TodoEntity entity = new TodoEntity();

        entity.setId(dto.id);
        entity.setTodoText(dto.todoText);
        entity.setTodoDate(dto.todoDate);
        entity.setIsCompleted(dto.isCompleted);

        return entity;
    }
}
