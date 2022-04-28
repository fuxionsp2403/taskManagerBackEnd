package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.max.taskmanagermax_api.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	 @Query("select x from Task x where x.proyecto.idProyecto = :var_project")
	public abstract List<Task> listaTareaPorProyecto(@Param("var_project")int idProyecto);

}
