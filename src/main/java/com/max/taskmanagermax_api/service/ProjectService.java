package com.max.taskmanagermax_api.service;

import java.util.List;


import com.max.taskmanagermax_api.DTO.ProjectDTO;
import com.max.taskmanagermax_api.DTO.SignInDTO;
import com.max.taskmanagermax_api.entity.Project;

public interface ProjectService {
//	public abstract List<Project> listadoProyectoPorUsuario(int idUsuario);
	ProjectDTO saveProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(ProjectDTO projectDTO, long id);
    
    ProjectDTO findProjectById(long id);
    
    void deleteProject(long id);
}
