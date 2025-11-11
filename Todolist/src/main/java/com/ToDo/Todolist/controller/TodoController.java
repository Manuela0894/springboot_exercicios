	package com.ToDo.Todolist.controller;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.ToDo.Todolist.dto.TodoResponseDto;
	import com.ToDo.Todolist.entities.TodoList;
	import com.ToDo.Todolist.repository.TodoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
	
	@RestController
	@CrossOrigin(origins = "*")
	@RequestMapping(value="todo")
	public class TodoController {
	
		@Autowired
		TodoRepository todoRepository;
		
		@PostMapping(value="create")
		public ResponseEntity<?> saveTodo (@Valid @RequestBody TodoList todo){
			TodoList todolist = new TodoList(todo.getName(), todo.getDescription(), todo.isStatus(), todo.getPriority(), todo.getListOrder());
			todoRepository.save(todo);
			
			TodoResponseDto responseDto = new TodoResponseDto(todolist);
			
			return ResponseEntity.ok(responseDto);
			
		}
		
		@DeleteMapping(value="delete/{id}")
		public ResponseEntity<?> deleteTodoList(@PathVariable @RequestBody long id){
		Optional<TodoList> todoList = todoRepository.findById(id);
		
		if(todoList.isPresent()) {
			 todoRepository.deleteById(id);
			 return ResponseEntity.ok("Tarefa deletada com sucesso.");
			
		}else {
			return ResponseEntity.status(404).body("Tarefa não encontrada.");
		}
		}
		
		@DeleteMapping(value="delete/all")
		@Transactional
		public ResponseEntity<?> deleteTodoListAll(){
		todoRepository.deleteAllInBatch();
		return ResponseEntity.noContent().build();
		}
		
		
		@PutMapping(value="update/{id}")
		public ResponseEntity<?> updateTodoList(@PathVariable @RequestBody long id, @RequestBody TodoList todoList){
			Optional<TodoList> newTodo = todoRepository.findById(id);
			
			if(newTodo.isPresent()) {
				TodoList e = newTodo.get();
				e.setName(todoList.getName());
				e.setDescription(todoList.getDescription());
				e.setStatus(todoList.isStatus());
				e.setPriority(todoList.getPriority());
				todoRepository.save(e);
				return ResponseEntity.ok(newTodo);
				}	
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Tarefa não encontrada");
				}
			}
		
		
		@GetMapping(value="search/{id}")
		public ResponseEntity<?> buscarId(@PathVariable long id){
			Optional<TodoList> todoList = todoRepository.findById(id);
			
			if(todoList.isPresent()) {
				TodoResponseDto idResearch = new TodoResponseDto(todoList.get()); 
				return ResponseEntity.status(HttpStatus.OK).body(idResearch);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
			}}
			
			
		@GetMapping("list")
		public List<TodoResponseDto> ListTodo(){
			List<TodoList> todolist = todoRepository.findAllByOrderByListOrderAsc();
			List<TodoResponseDto> listTodos = todolist.stream().map(TodoResponseDto::new).toList();
			return listTodos;
		}	
		}
		
	
