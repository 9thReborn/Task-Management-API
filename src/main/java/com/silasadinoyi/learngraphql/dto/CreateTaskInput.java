package com.silasadinoyi.learngraphql.dto;

import com.silasadinoyi.learngraphql.model.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskInput {
    @NotBlank(message = "Task title is required")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @Size(max = 5000, message = "Description must not exceed 5000 characters")
    private String description;

    private TaskPriority priority = TaskPriority.MEDIUM;

    private Long assigneeId;

    private LocalDate dueDate;
}
