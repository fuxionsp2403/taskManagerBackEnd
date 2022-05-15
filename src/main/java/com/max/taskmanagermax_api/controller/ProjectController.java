package com.max.taskmanagermax_api.controller;


import com.max.taskmanagermax_api.DTO.ProjectDTO;
import com.max.taskmanagermax_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.service.ProjectService;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping ("/api/projects")
@SuppressWarnings({"all"})
public class ProjectController {
    private final ProjectService projectService;
    
    private final UserRepository userRepository;
    
    public ProjectController(ProjectService projectService, UserRepository userRepository) {
        this.projectService = projectService;
        this.userRepository = userRepository;
    }
    
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProjectDTO> saveProject(@Valid @RequestBody ProjectDTO projectDTO) {
        return new ResponseEntity<>(projectService.saveProject(projectDTO), HttpStatus.OK);
    }
    
    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping ("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@Valid @RequestBody ProjectDTO projectDTO,
                                                    @PathVariable (name = "id") long id) {
        ProjectDTO projectResponse = projectService.updateProject(projectDTO, id);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable (name = "id") long id) {
        return ResponseEntity.ok(projectService.findProjectById(id));
    }
    
    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable (name = "id") long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>("Proyecto eliminado con éxito", HttpStatus.OK);
    }
}
