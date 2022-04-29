package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.max.taskmanagermax_api.entity.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Integer>{
	@Query("select x from Commentary x where x.tarea.idTarea = :var_tarea")
	public abstract List<Commentary> listadoComentarioPorTarea(@Param("var_tarea") int idTarea);
}
