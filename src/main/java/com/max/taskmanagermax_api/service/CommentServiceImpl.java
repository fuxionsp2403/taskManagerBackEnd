package com.max.taskmanagermax_api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


//import com.max.taskmanagermax_api.DTO.CommentDTO;
//import com.max.taskmanagermax_api.entity.Task;
//import com.max.taskmanagermax_api.entity.User;
//import com.max.taskmanagermax_api.exceptions.MaxAppException;
//import com.max.taskmanagermax_api.exceptions.ResourceNotFoundException;
//import com.max.taskmanagermax_api.repository.TaskRepository;
//import com.max.taskmanagermax_api.repository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import com.max.taskmanagermax_api.entity.Comment;
//import com.max.taskmanagermax_api.repository.CommentRepository;

//@Service
//public class CommentServiceImpl implements CommentService {
//    private final CommentRepository commentRepository;
//
//    private final ModelMapper modelMapper;
//
//    private final TaskRepository taskRepository;
//
//    private final UserRepository userRepository;
//
//    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, TaskRepository taskRepository, UserRepository userRepository) {
//        this.commentRepository = commentRepository;
//        this.modelMapper = modelMapper;
//        this.taskRepository = taskRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<Comment> listadoComentarioPorTarea(int idTarea) {
//        return commentRepository.listadoComentarioPorTarea(idTarea);
//    }
//
//    @Override
//    public CommentDTO saveComment(long taskId, CommentDTO commentDTO, long userId) {
//        User user = userRepository
//                .findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        Comment comment = mappingEntity(commentDTO);
//        Task task = taskRepository
//                .findById(taskId)
//                .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
//        comment.setTarea(task);
//        comment.setUserId(user);
//        Comment newComment = commentRepository.save(comment);
//        return mappingDTO(newComment);
//    }
//
//    @Override
//    public CommentDTO updateComment(long commentId, long taskId, CommentDTO commentRequest, long userId) {
//        TaskCommentUser(taskId, userId, commentId).setContenidoComentario(commentRequest.getContenido());
//        TaskCommentUser(taskId, userId, commentId).setFechaRegistro(new Date());
//
//        Comment updatedComment = commentRepository.save(TaskCommentUser(taskId, userId, commentId));
//        return mappingDTO(updatedComment);
//    }
//
//    @Override
//    public CommentDTO findCommentById(long taskId, long commentId, long userId) {
//        return mappingDTO(TaskCommentUser(taskId, userId, commentId));
//    }
//
//    @Override
//    public List<CommentDTO> findCommentsByTaskId(long taskId) {
//        List<Comment> comments = commentRepository.findByTaskId(taskId);
//        return comments.stream()
//                .map(this::mappingDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteComment(long taskId, long commentId, long userId) {
//        TaskCommentUser(taskId, userId, commentId);
//        commentRepository.delete(TaskCommentUser(taskId, userId, commentId));
//    }
//
//
//    private CommentDTO mappingDTO(Comment comment) {
//        return modelMapper.map(comment, CommentDTO.class);
//    }
//
//    private Comment mappingEntity(CommentDTO commentDTO) {
//        return modelMapper.map(commentDTO, Comment.class);
//    }
//
//    private Comment TaskCommentUser (long taskId, long userId, long commentId) {
//        Task task = taskRepository
//                .findById(taskId)
//                .orElseThrow(()-> new ResourceNotFoundException("Task", "id", taskId));
//        User user = userRepository
//                .findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        Comment comment = commentRepository
//                .findById(commentId)
//                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
//
//        if (!comment.getTarea().getIdTarea().equals(task.getIdTarea())) {
//            throw new MaxAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la tarea");
//        }
//        if (!comment.getUserId().getId().equals(user.getId())) {
//            throw new MaxAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece al usuario");
//        }
//        return comment;
//    }
//
//
//}
