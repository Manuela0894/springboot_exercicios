package com.ToDo.Todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDo.Todolist.entities.TodoList;


public interface TodoRepository extends JpaRepository<TodoList, Long> {

	List<TodoList> findAllByOrderByListOrderAsc();
	
	
}
