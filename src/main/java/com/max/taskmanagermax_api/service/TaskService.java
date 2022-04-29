package com.max.taskmanagermax_api.service;

import java.util.List;

import com.max.taskmanagermax_api.entity.Task;

public interface TaskService {
	public abstract List<Task> listaTareaPorProyecto(int idProyecto);
	public abstract Task registrarActualizarTarea(Task task);
}
