package com.ToDo.Todolist.dto;
import com.ToDo.Todolist.entities.enums.EPriority;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDto {
	
	@NotBlank(message="O nome não pode ser nulo") @Size(max = 20, message="O nome não pode ser nulo")
	private String name;
	@Size( max = 300, message = "A senha deve ter entre 6 e 20 caracteres")
	private String description;
	private boolean status;
	@Enumerated(EnumType.STRING)
	private EPriority priority;
	private int listOrder;
	
	public TodoRequestDto() {}

	public TodoRequestDto(String name, String description, boolean status, EPriority priority, int listOrder) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.listOrder = listOrder;
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
