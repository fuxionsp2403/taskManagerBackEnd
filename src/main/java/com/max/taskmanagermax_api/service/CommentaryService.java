package com.max.taskmanagermax_api.service;

import java.util.List;
import com.max.taskmanagermax_api.entity.Commentary;

public interface CommentaryService {
	public abstract List<Commentary> listadoComentarioPorTarea(int idTarea);
	public abstract Commentary registrarActualizaComentario(Commentary comentario);

}
