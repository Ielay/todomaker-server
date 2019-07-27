package com.todomaker.todomakerserver.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author petrov
 * @since 20.07.19
 */

@Getter
@Setter
@ToString
public class TodoEntity {

    public TodoEntity() {
        
    }

    private Long id;

    private String todoText;

    private LocalDate todoDate;

    private Boolean isCompleted;
}
