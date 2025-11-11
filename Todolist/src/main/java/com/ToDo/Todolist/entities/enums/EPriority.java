package com.ToDo.Todolist.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EPriority {

	BAIXA(1),
	MEDIA(2),
	URGENTE(3);
	
	private final int level;
	
	@JsonCreator
    public static EPriority fromString(String value) {
        return EPriority.valueOf(value.toUpperCase()); 
    }

	private EPriority(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	
}
