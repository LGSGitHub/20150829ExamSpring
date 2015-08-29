package com.hand.Exam;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;
	}

	public void beforeInsert() {
		BeforeInsertEvent ce = new BeforeInsertEvent(this);
		publisher.publishEvent(ce);
	}
	
	public void afterInsert() {
		AfterInsertEvent ce = new AfterInsertEvent(this);
		publisher.publishEvent(ce);
	}

}
