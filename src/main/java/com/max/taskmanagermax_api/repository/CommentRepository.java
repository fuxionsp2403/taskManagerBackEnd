package com.max.taskmanagermax_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.max.taskmanagermax_api.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByTareaIdTarea(Long taskId);
}
