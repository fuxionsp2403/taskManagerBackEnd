package com.max.taskmanagermax_api.controller;


import com.max.taskmanagermax_api.DTO.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.service.ProjectService;


import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping ("/api/project")
@SuppressWarnings({"all"})
public class ProjectController {
    private final ProjectService projectService;
    
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
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
        return ResponseEntity.ok("Proyecto eliminado con éxito" + HttpStatus.OK);
    }
}
