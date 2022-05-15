package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
//	@Query(value="{CALL listadoProyectoPorUsuario(:var_user)}", nativeQuery = true)
//	public abstract List<Project> listadoProyectoPorUsuario(@Param("var_user") int idTarea);
}
