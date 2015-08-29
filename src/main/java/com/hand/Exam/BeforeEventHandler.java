package com.hand.Exam;

import org.springframework.context.ApplicationListener;

public class BeforeEventHandler implements ApplicationListener<BeforeInsertEvent> {

	public void onApplicationEvent(BeforeInsertEvent event) {
		System.out.println(event.afterInsert());
	}

}
