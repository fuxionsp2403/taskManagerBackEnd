package com.max.taskmanagermax_api.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import com.max.taskmanagermax_api.DTO.TaskDTO;
import com.max.taskmanagermax_api.entity.Project;
import com.max.taskmanagermax_api.entity.User;
import com.max.taskmanagermax_api.exceptions.MaxAppException;
import com.max.taskmanagermax_api.exceptions.ResourceNotFoundException;
import com.max.taskmanagermax_api.repository.ProjectRepository;
import com.max.taskmanagermax_api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;


    private final ModelMapper    modelMapper;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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
        
        Set<User> user = new HashSet<>();
        
        for (int i = 0; i < taskDTO.getNameUser().size(); i++) {
            user.add(userRepository.findByUsername((taskDTO.getNameUser().get(i))));
        }
        
        task.setUsuarios(user);
        
        if (task.getFechaFinaliza().before(new Date())) {
            throw new MaxAppException(HttpStatus.BAD_REQUEST, "La tarea tiene que programarse un día después de la fecha esperada");
        } else {
            task.setFechaFinaliza(project.getFechaFinaliza());
        }
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
