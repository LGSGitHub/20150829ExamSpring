package com.hand.Exam;

import org.springframework.context.ApplicationListener;

public class AfterEventHandler implements ApplicationListener<AfterInsertEvent> {

	public void onApplicationEvent(AfterInsertEvent event) {
		System.out.println(event.afterInsert());

	}

}
