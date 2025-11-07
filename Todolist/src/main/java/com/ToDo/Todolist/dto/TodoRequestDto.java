package com.ToDo.Todolist.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDto {
	
	@NotBlank(message="O nome não pode ser nulo") @Size(max = 20, message="O nome não pode ser nulo")
	private String name;
	@Size( max = 300, message = "A senha deve ter entre 6 e 20 caracteres")
	private String description;
	private boolean status;
	private int priority;
	
	public TodoRequestDto() {}

	public TodoRequestDto(String name, String description, boolean status, int priority) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.priority = priority;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
	

}
