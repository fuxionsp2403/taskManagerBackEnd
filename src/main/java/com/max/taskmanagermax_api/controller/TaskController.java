package com.max.taskmanagermax_api.controller;

import java.util.*;


import com.max.taskmanagermax_api.DTO.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.service.TaskService;


import javax.validation.Valid;

@RestController
@RequestMapping ("/api/")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    
    @GetMapping ("/projects/{projectId}/tasks/{taskId}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable (value = "projectId") long projectId,
                                           @PathVariable (value = "taskId") long taskId) {
        TaskDTO task = taskService.findTaskById(projectId, taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    
    @GetMapping ("/projects/{projectId}/tasks")
    public List<TaskDTO> getTasks(@PathVariable (value = "projectId") long projectId) {
        return taskService.findTasksByProjectId(projectId);
    }
    
    @PostMapping ("/project/{projectId}/tasks")
    public ResponseEntity<TaskDTO> createTask(@PathVariable (value = "projectId") long projectId,
                                              @Valid @RequestBody TaskDTO taskDTO) {
        
        return new ResponseEntity<>(taskService.saveTask(projectId, taskDTO), HttpStatus.CREATED);
    }
    
    @PutMapping ("/projects/{projectId}/tasks/{taskId}")
    @ResponseBody
    public ResponseEntity<TaskDTO> updateTask(@PathVariable (value = "projectId") long projectId,
                                              @PathVariable (value = "taskId") long taskId,
                                              @RequestBody TaskDTO taskDTO) {
        TaskDTO updateTasktById = taskService.updateTask(projectId, taskId, taskDTO);
        return new ResponseEntity<>(updateTasktById, HttpStatus.OK);
    }
    
    @DeleteMapping ("/projects/{projectId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable (value = "projectId") long projectId,
                                             @PathVariable (value = "taskId") long taskId) {
        taskService.deleteTask(projectId, taskId);
        return new ResponseEntity<>("Tarea eliminada con éxito", HttpStatus.OK);
    }
}
