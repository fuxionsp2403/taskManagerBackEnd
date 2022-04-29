package com.max.taskmanagermax_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.max.taskmanagermax_api.entity.Commentary;
import com.max.taskmanagermax_api.repository.CommentaryRepository;

@Service
public class CommentaryServiceImplement implements CommentaryService {
	@Autowired
	private CommentaryRepository repository;

	@Override
	public List<Commentary> listadoComentarioPorTarea(int idTarea) {
		return repository.listadoComentarioPorTarea(idTarea);
	}

	@Override
	public Commentary registrarActualizaComentario(Commentary comentario) {
		return repository.save(comentario);
	}

	
	
}
