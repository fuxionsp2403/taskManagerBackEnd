package com.max.taskmanagermax_api.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.entity.Project;
import com.max.taskmanagermax_api.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService service;
	
	@GetMapping("/{user}")
	@ResponseBody
	public ResponseEntity<List<Project>> listaDeProyectos(@PathVariable("user")int user){
		return ResponseEntity.ok(service.listadoProyectoPorUsuario(user));
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarProyecto(@RequestBody Project proyecto){
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			proyecto.setIdProyecto(0);
			proyecto.setFechaRegistro(new Date());
			proyecto.setEstado(1);
			Project respuestaProyecto=service.registrarActualizaProyecto(proyecto);
			if(respuestaProyecto==null) {
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
	public ResponseEntity<HashMap<String, Object>> actualizaProyecto(@RequestBody Project proyecto) {
		HashMap<String, Object> mensajeRespuesta = new HashMap<String, Object>();
		try {
			Project respuestaProyecto=service.registrarActualizaProyecto(proyecto);
			if(respuestaProyecto==null) {
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
