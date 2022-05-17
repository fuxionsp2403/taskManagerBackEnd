# **Task Manager Max (API)** :bookmark_tabs:

> ## ¿Como consumir nuestros endpoints?
---
     - Antes de cada endopint va la palabra clave api/***
     - Las autenticaciones al iniciar sesión se hacen con un token (seguridad tipo bearer)
     - Solo roles de administrador pueden crear proyectos

```yaml 
|- Autenticacion 	
|		|
|		|- Para Iniciar Sesion : auth/signIn
|		|		|
|		|		|- Metodo: POST
|		|		|
|		|		|- Request: {
|		|		|		"usernameOrEmail": "",
|		|		|		"password": ""
|		|		|	    }
|		|		|
|		|		|- Response: {
|		|				"accessToken": "",
|		|			        "tokenType": "",
|		|				"username": "",
|		|				"authorities": [
|		|						    {
|		|						        "authority": ""
|		|						    },
|		|						    {
|		|						        "authority": ""
|		|						    }
|		|					        ]
|		|				}
|		|
|		|- Para Registrarse : auth/signUp
|				|
|				|- Metodo: POST
|				|
|				|- Request: {
|				|		"nombre": "",
|				|		"apellido": "",
|				|		"username": "",
|				|		"email": "",
|				|		"password": "",
|				|		"roles": [""]
|				|	    }
|				|			
|				|- Response: "menesaje"
|
|
|	
|- Proyectos
|		|
|		|- Para Registrar Proyecto : projects
|		|		|
|		|		|- Metodo: POST
|		|		|
|		|		|- Request: {
|		|		|		"nombreProyecto":"",
|		|		|		"fechaFinaliza":"yyyy-MM-dd",
|		|		|		"nameUser": ["nameUser"]
|		|		|	    }
|		|		|			
|		|		|- Response: { Proyecto }
|		|
|		|- Para Actualizar Proyecto : projects/{id}
|		|		|
|		|		|- Metodo: PUT
|		|		|
|		|		|- Request: {
|		|		|		"nombreProyecto":"",
|		|		|		"fechaFinaliza":"yyyy-MM-dd",
|		|		|		"nameUser": ["nameUser"]
|		|		|	    }
|		|		|			
|		|		|- Response: { Proyecto }
|		|
|		|- Para Obetener un Proyecto : projects/{id}
|		|		|
|		|		|- Metodo: GET
|		|
|		|- Para Obetener todos los Proyecto (10 por defecto): projects
|		|		|
|		|		|- Metodo: GET
|		|
|		|- Para Obetener todos los Proyectos con paginado : projects?`queryParams`
|		|		|
|		|		|- Metodo: GET
|		|		|
|		|		|- Ejemplo de QueryParams: sortBy=idProyecto&sortDir=desc&pageNo=24&pageSize=2
|		|
|		|- Para Eliminar Proyecto : projects/{id}
|				|
|				|- Metodo: DELETE
|				|
|				|- Response: "menesaje"
|
|
|
|-  Tareas
|		|
|		|- Para Crear Tarea por Proyecto : projects/{projectId}/tasks
|		|		|
|		|		|- Metodo: POST
|		|		|
|		|		|- Request: {
|		|		|		"nombreTarea":"",
|		|		|		"contenidoTarea":"",
|		|		|		"fechaFinaliza":"yyyy-MM-dd"
|		|		|	    }
|		|		|
|		|		|- Response: { Tarea }
|		|
|		|- Para Obetener todas las Tareas por Proyecto : projects/{projectId}/tasks
|		|		|
|		|		|- Metodo: GET
|		|		|
|		|		|- Response: [ Listado de Tareas ]
|		|
|		|- Para Obetener una Tarea por Proyecto : projects/{projectId}/tasks/{taskId}
|		|		|
|		|		|- Metodo: GET
|		|		|
|		|		|- Response: { Tarea }
|		|
|		|- Para Actualizar una Tarea por Proyecto : projects/{projectId}/tasks/{taskId}
|		|		|
|		|		|- Metodo: PUT
|		|		|
|		|		|- Request: {
|		|		|		"idTarea": number,
|		|		|		"nombreTarea": "",
|		|		|		"contenidoTarea": "",
|		|		|		"fechaFinaliza": "yyyy-MM-dd",
|		|		|		"estado": 1
|		|		|	    }
|		|		|
|		|		|- Response: { Tarea }
|		|
|		|- Para Eliminar una Tarea por Proyecto : projects/{projectId}/tasks/{taskId}
|				|
|				|- Metodo: DELETE
|				|
|				|- Response: "menesaje"
|
|
|
|-  Comentarios
|		|
|		|- Para Crear un Comentario : tasks/{taskId}/comments
|		|		|
|		|		|- Metodo: POST
|		|		|
|		|		|- Request: {
|		|		|		"contenido":"No se puede xd"
|		|		|	    }
|		|		|
|		|		|- Response: { Comentario }
|		|
|		|- Para Obetener todos los Comentarios por Tarea : tasks/{taskId}/comments
|		|		|
|		|		|- Metodo: GET
|		|		|
|		|		|- Response: [ Listado de Comentarios ]
|		|
|		|- Para Obetener un Comentario por Tarea : tasks/{taskId}/comments/{commentId}
|		|		|
|		|		|- Metodo: GET
|		|		|
|		|		|- Response: { Comentario }
|		|
|		|- Para Actualizar un Comentario por Tarea : tasks/{taskId}/comments/{commentId}
|		|		|
|		|		|- Metodo: PUT
|		|		|
|		|		|- Request: {
|		|		|		"idComentario": number,
|		|		|		"contenido":""
|		|		|	    }
|		|		|
|		|		|- Response: { Comentario }
|		|
|		|- Para Eliminar un Comentario por Tarea : tasks/{taskId}/comments/{commentId}
|				|
|				|- Metodo: DELETE
|				|
|				|- Response: "menesaje"
|
```
