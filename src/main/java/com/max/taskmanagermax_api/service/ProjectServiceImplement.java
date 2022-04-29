package com.max.taskmanagermax_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.taskmanagermax_api.entity.Project;
import com.max.taskmanagermax_api.repository.ProjectRepository;

@Service
public class ProjectServiceImplement implements ProjectService {
	@Autowired
	private ProjectRepository repository;

	@Override
	public List<Project> listadoProyectoPorUsuario(int idUsuario) {
		return repository.listadoProyectoPorUsuario(idUsuario);
	}

	@Override
	public Project registrarActualizaProyecto(Project proyecto) {
		return repository.save(proyecto);
	}

}
