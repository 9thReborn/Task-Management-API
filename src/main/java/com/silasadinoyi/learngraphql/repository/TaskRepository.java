package com.silasadinoyi.learngraphql.repository;

import com.silasadinoyi.learngraphql.model.Task;
import com.silasadinoyi.learngraphql.model.TaskPriority;
import com.silasadinoyi.learngraphql.model.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);

    Page<Task> findByPriority(TaskPriority priority, Pageable pageable);

    Page<Task> findByAssigneeId(Long assigneeId, Pageable pageable);

    /** Dynamic filtering — null params are ignored */
    @Query("""
        SELECT t FROM Task t
        WHERE (:status IS NULL OR t.status = :status)
          AND (:priority IS NULL OR t.priority = :priority)
          AND (:assigneeId IS NULL OR t.assignee.id = :assigneeId)
        ORDER BY t.createdAt DESC
    """)
    Page<Task> findWithFilters(
            @Param("status")     TaskStatus status,
            @Param("priority")   TaskPriority priority,
            @Param("assigneeId") Long assigneeId,
            Pageable pageable
    );

    /** Used by @BatchMapping resolver to avoid N+1 queries */
    @Query("SELECT t FROM Task t LEFT JOIN FETCH t.assignee WHERE t.id IN :ids")
    List<Task> findAllWithAssigneeByIds(@Param("ids") List<Long> ids);
}
