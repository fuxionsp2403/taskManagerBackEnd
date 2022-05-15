package com.max.taskmanagermax_api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.max.taskmanagermax_api.DTO.TaskDTO;
import com.max.taskmanagermax_api.entity.Project;
import com.max.taskmanagermax_api.exceptions.MaxAppException;
import com.max.taskmanagermax_api.exceptions.ResourceNotFoundException;
import com.max.taskmanagermax_api.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;


    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDTO saveTask(long projectId, TaskDTO taskDTO) {
        Task task = mappingEntity(taskDTO);
        Project project = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
        task.setProyecto(project);
        task.setFechaRegistro(new Date());
        task.setEstado(1);
        Task newTask = taskRepository.save(task);
        return mappingDTO(newTask);
    }

    @Override
    public TaskDTO updateTask(long projectId, long taskId, TaskDTO taskRequest) {

        ProjectTask(projectId, taskId).setNombreTarea(taskRequest.getNombreTarea());
        ProjectTask(projectId, taskId).setContenidoTarea(taskRequest.getContenidoTarea());
        ProjectTask(projectId, taskId).setFechaFinaliza(taskRequest.getFechaFinaliza());
        ProjectTask(projectId, taskId).setEstado(1);
        ProjectTask(projectId, taskId).setFechaRegistro(new Date());

        Task updatedTask = taskRepository.save(ProjectTask(projectId, taskId));
        return mappingDTO(updatedTask);
    }

    @Override
    public TaskDTO findTaskById(long projectId, long taskId) {

        return mappingDTO(ProjectTask(projectId, taskId));

    }

    @Override
    public List<TaskDTO> findTasksByProjectId(long projectId) {
        List<Task> tasks = taskRepository.findByProyectoIdProyecto(projectId);
        return tasks.stream()
                .map(this::mappingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(long projectId, long taskId) {
        Project project = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));

        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
        if (!task.getProyecto().getIdProyecto().equals(project.getIdProyecto())) {
            throw new MaxAppException(HttpStatus.BAD_REQUEST, "El comentario no es del proyecto");
        }

        taskRepository.delete(task);

    }

    private TaskDTO mappingDTO(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

    private Task mappingEntity(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }

    private Task ProjectTask(long projectId, long taskId) {
        Project project = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));

        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

        if (!task.getProyecto().getIdProyecto().equals(project.getIdProyecto())) {
            throw new MaxAppException(HttpStatus.BAD_REQUEST, "La tarea no pertenece al proyecto");
        }

        return task;
    }


}
