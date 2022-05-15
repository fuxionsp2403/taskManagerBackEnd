package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
//	@Query("select x from Comment x where x.tarea.idTarea = :var_tarea")
//	public abstract List<Comment> listadoComentarioPorTarea(@Param("var_tarea") int idTarea);

    List<Comment> findByTareaIdTarea(Long taskId);


}
