package com.ToDo.Todolist.entities;

import com.ToDo.Todolist.entities.enums.EPriority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tarefas")
public class TodoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private boolean status;
	@Enumerated(EnumType.STRING)
	private EPriority priority;
	
	public TodoList() {}
	
	public TodoList(String name, String description, boolean status, EPriority priority) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.priority = priority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
