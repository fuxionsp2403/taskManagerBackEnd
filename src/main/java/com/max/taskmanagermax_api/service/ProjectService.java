package com.max.taskmanagermax_api.service;

import java.util.List;

import com.max.taskmanagermax_api.entity.Project;

public interface ProjectService {
	public abstract List<Project> listadoProyectoPorUsuario(int idUsuario);
	public abstract Project registrarActualizaProyecto(Project proyecto);
}
