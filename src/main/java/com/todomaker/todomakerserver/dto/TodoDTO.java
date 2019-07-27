package com.todomaker.todomakerserver.dto;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class TodoDTO {

    public Long id;

    public String todoText;

    public LocalDate todoDate;

    public Boolean isCompleted;
}
