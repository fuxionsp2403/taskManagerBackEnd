package com.max.taskmanagermax_api.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByProyectoIdProyecto(Long projectId);
}
