package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.max.taskmanagermax_api.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	//@Query("select x from Project x where x.usuario.idUsuario = :var_user")
	@Query("select x from Project x where x.idUsuario = :var_user")
	public abstract List<Project> listadoProyectoPorUsuario(@Param("var_user") int idTarea);
}
