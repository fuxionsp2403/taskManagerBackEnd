package com.max.taskmanagermax_api.service;

import java.util.*;
import java.util.stream.Collectors;


import com.max.taskmanagermax_api.DTO.ProjectDTO;
import com.max.taskmanagermax_api.entity.User;
import com.max.taskmanagermax_api.exceptions.MaxAppException;
import com.max.taskmanagermax_api.exceptions.ResourceNotFoundException;
import com.max.taskmanagermax_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.max.taskmanagermax_api.entity.Project;
import com.max.taskmanagermax_api.repository.ProjectRepository;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    
    private final ModelMapper       modelMapper;
    private final ProjectRepository projectRepository;
    private final UserRepository    userRepository;
    
    @Autowired
    public ProjectServiceImpl(ModelMapper modelMapper, ProjectRepository projectRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }
    
//    @Override
//    public List<Project> listadoProyectoPorUsuario(int idUsuario) {
//        return projectRepository.listadoProyectoPorUsuario(idUsuario);
//    }
    
    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        
        
        Project project = mappingEntity(projectDTO);
        project.setFechaRegistro(new Date());
        project.setEstado(1);
        Set<User> user = new HashSet<>();
        
        for (int i = 0; i < projectDTO.getNameUser().size(); i++) {
            user.add(userRepository.findByUsername((projectDTO.getNameUser().get(i))));
        }
        
        project.setUsuarios(user);
        
        Project newProject = projectRepository.save(project);
        
        return mappingDTO(newProject);
    }
    
    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO, long id) {
        
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));
        
        project.setEstado(projectDTO.getEstado());
        project.setFechaRegistro(new Date());
        project.setNombreProyecto(projectDTO.getNombreProyecto());
        project.setFechaFinaliza(projectDTO.getFechaFinaliza());
    
        Set<User> user = new HashSet<>();
    
        for (int i = 0; i < projectDTO.getNameUser().size(); i++) {
            user.add(userRepository.findByUsername((projectDTO.getNameUser().get(i))));
        }
    
        project.setUsuarios(user);
        
        Project updateProject = projectRepository.save(project);
        return mappingDTO(updateProject);
    }
    
    @Override
    public ProjectDTO findProjectById(long id) {
        Project project = projectRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project", "id", id));
        return mappingDTO(project);
    }
    
    @Override
    public void deleteProject(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        projectRepository.delete(project);
        
    }
    
    private ProjectDTO mappingDTO(Project proyecto) {
        return modelMapper.map(proyecto, ProjectDTO.class);
    }
    
    private Project mappingEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }
    
}
