package com.max.taskmanagermax_api.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	@Autowired
	private TaskService service;
	
	@GetMapping("/{project}")
	@ResponseBody
	public ResponseEntity<List<Task>> listaDeTareas(@PathVariable("project")int proyecto){
		return ResponseEntity.ok(service.listaTareaPorProyecto(proyecto));
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarTarea(@RequestBody Task task){
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			task.setIdTarea(0);
			task.setFechaRegistro(new Date());
			task.setEstado(1);
			Task respuestaTask=service.registrarActualizarTarea(task);
			if(respuestaTask==null) {
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
	public ResponseEntity<HashMap<String, Object>> actualizaTarea(@RequestBody Task task){
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			Task respuestaTask=service.registrarActualizarTarea(task);
			if(respuestaTask==null) {
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
