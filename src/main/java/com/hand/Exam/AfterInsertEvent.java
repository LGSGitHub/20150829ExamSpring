package com.hand.Exam;

import org.springframework.context.ApplicationEvent;

public class AfterInsertEvent extends ApplicationEvent {

	public AfterInsertEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String afterInsert() {
		return "After Insert Film Data";
	}

}
