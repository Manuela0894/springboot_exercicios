package com.ToDo.Todolist.entities.enums;

public enum EPriority {

	BAIXA(1),
	MEDIA(2),
	URGENTE(3);
	
	private final int level;

	private EPriority(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	
}
