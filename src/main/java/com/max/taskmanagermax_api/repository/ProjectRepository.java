package com.max.taskmanagermax_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByNombreProyecto(String nombreProyecto);
}
