package com.max.taskmanagermax_api.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.entity.Commentary;
import com.max.taskmanagermax_api.service.CommentaryService;

@RestController
@RequestMapping("/url/commentary")
public class CommentaryController {
	@Autowired
	private CommentaryService service;
	
	@GetMapping("/{task}")
	@ResponseBody
	public ResponseEntity<List<Commentary>> listaDeComentarios(@PathVariable("task")int task){
		return ResponseEntity.ok(service.listadoComentarioPorTarea(task));
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarComentario(@RequestBody Commentary comentario){
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			comentario.setIdComentario(0);
			comentario.setFechaRegistro(new Date());
			Commentary respuestaComentario=service.registrarActualizaComentario(comentario);
			if(respuestaComentario==null) {
				mensajeRespuesta.put("message", "Error en el registro ");
				mensajeRespuesta.put("status", "error");
			}else {
				mensajeRespuesta.put("message", "Registro Exitoso ");
				mensajeRespuesta.put("status", "OK");
			}
		}catch (Exception e) {
			e.printStackTrace();
			mensajeRespuesta.put("message", "Error en el registro " + e.getMessage());
			mensajeRespuesta.put("status", "error");
		}
		return ResponseEntity.ok(mensajeRespuesta);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizaAlumno(@RequestBody Commentary comentario) {
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			Commentary respuestaComentario=service.registrarActualizaComentario(comentario);
			if(respuestaComentario==null) {
				mensajeRespuesta.put("message", "Error al Atualizar ");
				mensajeRespuesta.put("status", "error");
			}else {
				mensajeRespuesta.put("message", "Actualizacion Exitosa ");
				mensajeRespuesta.put("status", "OK");
			}
		}catch (Exception e) {
			e.printStackTrace();
			mensajeRespuesta.put("message", "Error en el registro " + e.getMessage());
			mensajeRespuesta.put("status", "error");
		}
		return ResponseEntity.ok(mensajeRespuesta);
	}
	
}
