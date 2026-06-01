package com.silasadinoyi.learngraphql.dto;

import com.silasadinoyi.learngraphql.model.TaskPriority;
import com.silasadinoyi.learngraphql.model.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTaskInput {
    @Size(max = 255)
    private String title;

    @Size(max = 5000)
    private String description;

    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
}
