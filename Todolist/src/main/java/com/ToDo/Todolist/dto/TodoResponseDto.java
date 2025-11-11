package com.ToDo.Todolist.dto;

import com.ToDo.Todolist.entities.TodoList;
import com.ToDo.Todolist.entities.enums.EPriority;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TodoResponseDto {

	private String name;
	private String description;
	private boolean status;
	@Enumerated(EnumType.STRING)
	private EPriority priority;
	private int listOrder;
	
	public TodoResponseDto(TodoList todo) {
		this.name = todo.getName();
		this.description = todo.getDescription();
		this.status = todo.isStatus();
		this.priority = todo.getPriority();
		this.listOrder = todo.getListOrder();
	}

	public int getListOrder() {
		return listOrder;
	}

	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EPriority getPriority() {
		return priority;
	}

	public void setPriority(EPriority priority) {
		this.priority = priority;
	}	
	
	
	
	
		
	}
	
	

