package com.max.taskmanagermax_api.service;

import java.util.List;


import com.max.taskmanagermax_api.DTO.CommentDTO;
import com.max.taskmanagermax_api.DTO.ProjectDTO;
import com.max.taskmanagermax_api.entity.Comment;

public interface CommentService {
//    public abstract List<Comment> listadoComentarioPorTarea(int idTarea);

    CommentDTO saveComment(long taskId, CommentDTO commentDTO);

    CommentDTO updateComment(long commentId, long taskId, CommentDTO commentRequest);

    CommentDTO findCommentById(long taskId, long commentId);

    List<CommentDTO> findCommentsByTaskId(long taskId);

    void deleteComment(long taskId, long commentId);

}
