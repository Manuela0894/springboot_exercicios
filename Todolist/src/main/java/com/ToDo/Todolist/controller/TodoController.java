package com.ToDo.Todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDo.Todolist.entities.TodoList;
import com.ToDo.Todolist.repository.TodoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="todo")
public class TodoController {

	@Autowired
	TodoRepository todoRepository;
	
	@PostMapping(value="create")
	public ResponseEntity<?> saveTodo (@Valid TodoList todo){
		TodoList todolist = new TodoList(todo.getName(), todo.getDescription(), todo.isStatus(), todo.getPriorty());
		todoRepository.save(todo);
		return ReponseEntity.ok("Tarefa salva com sucesso");
		
	}
	
}
