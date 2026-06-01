package com.silasadinoyi.learngraphql.dto;

import com.silasadinoyi.learngraphql.model.Task;
import com.silasadinoyi.learngraphql.model.TaskPriority;
import com.silasadinoyi.learngraphql.model.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private Long assigneeId;
    private String assigneeUsername;
    private Long createdById;
    private String createdByUsername;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TaskResponse from(Task task) {
        TaskResponse dto = new TaskResponse();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        if (task.getAssignee() != null) {
            dto.setAssigneeId(task.getAssignee().getId());
            dto.setAssigneeUsername(task.getAssignee().getUsername());
        }
        if (task.getCreatedBy() != null) {
            dto.setCreatedById(task.getCreatedBy().getId());
            dto.setCreatedByUsername(task.getCreatedBy().getUsername());
        }
        return dto;
    }
}
