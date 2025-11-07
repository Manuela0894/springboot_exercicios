package com.ToDo.Todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDo.Todolist.entities.TodoList;


public interface TodoRepository extends JpaRepository<TodoList, Long> {

	
	
}
