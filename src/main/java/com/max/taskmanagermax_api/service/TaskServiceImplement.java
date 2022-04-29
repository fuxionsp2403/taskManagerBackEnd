package com.max.taskmanagermax_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.repository.TaskRepository;

@Service
public class TaskServiceImplement implements TaskService {
	
	@Autowired
	private TaskRepository repository;

	@Override
	public List<Task> listaTareaPorProyecto(int idProyecto) {
		return repository.listaTareaPorProyecto(idProyecto);
	}

	@Override
	public Task registrarActualizarTarea(Task task) {
		return repository.save(task);
	}

}
