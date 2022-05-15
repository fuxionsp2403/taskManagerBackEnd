package com.max.taskmanagermax_api.controller;

import java.util.*;


//import com.max.taskmanagermax_api.DTO.CommentDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.max.taskmanagermax_api.entity.Comment;
//import com.max.taskmanagermax_api.service.CommentService;
//
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api/")
//public class CommentController {
//	private final CommentService commentService;
//
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
//
//    @GetMapping("/{task}")
//	@ResponseBody
//	public ResponseEntity<List<Comment>> listaDeComentarios(@PathVariable("task")int task){
//		return ResponseEntity.ok(commentService.listadoComentarioPorTarea(task));
//	}
//
//	@PostMapping("/task/{taskId}/comments")
//	public ResponseEntity<CommentDTO> saveComment(@PathVariable (value = "taskId") long taskId,
//                                                  @Valid @RequestBody CommentDTO commentDTO) {
//		return new ResponseEntity<>(commentService.saveComment(taskId, commentDTO), HttpStatus.CREATED);
//	}
//
//	@PutMapping
//	@ResponseBody
//	public ResponseEntity<HashMap<String, Object>> actualizaAlumno(@RequestBody Comment comentario) {
//		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
//		try {
//			Comment respuestaComentario= commentService.registrarActualizaComentario(comentario);
//			if(respuestaComentario==null) {
//				mensajeRespuesta.put("message", "Error al Atualizar ");
//				mensajeRespuesta.put("status", "error");
//			}else {
//				mensajeRespuesta.put("message", "Actualizacion Exitosa ");
//				mensajeRespuesta.put("status", "OK");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			mensajeRespuesta.put("message", "Error en el registro " + e.getMessage());
//			mensajeRespuesta.put("status", "error");
//		}
//		return ResponseEntity.ok(mensajeRespuesta);
//	}
//
//}
