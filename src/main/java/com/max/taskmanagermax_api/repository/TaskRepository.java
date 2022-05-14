package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 @Query("select x from Task x where x.proyecto.idProyecto = :var_project")
	public abstract List<Task> listaTareaPorProyecto(@Param("var_project")int idProyecto);
     
     List<Task> findByProjectId(Long projectId);

}
