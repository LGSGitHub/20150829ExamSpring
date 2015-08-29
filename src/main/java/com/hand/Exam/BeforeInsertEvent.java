package com.hand.Exam;

import org.springframework.context.ApplicationEvent;

public class BeforeInsertEvent extends ApplicationEvent {

	public BeforeInsertEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String afterInsert() {
		return "Before Insert Film Data";
	}

}
