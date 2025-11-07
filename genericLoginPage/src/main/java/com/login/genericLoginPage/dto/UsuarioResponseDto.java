package com.login.genericLoginPage.dto;

import com.login.genericLoginPage.entity.Usuario;

public class UsuarioResponseDto {

	
	private int id;
	private String name;
	private String email;
	
	public UsuarioResponseDto(Usuario usuario) {
		this.id = usuario.getId();
		this.name = usuario.getName();
		this.email = usuario.getEmail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}
