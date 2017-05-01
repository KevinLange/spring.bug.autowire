package de.kla.spring.bug.autowire.constructor;

import javax.annotation.PostConstruct;

import org.junit.Assert;

import de.kla.spring.bug.autowire.SpringJobFactory;

public class ConstructorService {

	private SpringJobFactory springJobFactory;
	private Object entity;

	public ConstructorService(SpringJobFactory springJobFactory) {
		Assert.assertNotNull("springJobFactory must not be null", springJobFactory);
		this.springJobFactory = springJobFactory;
	}
	

	@PostConstruct
	public void init() {
		entity = springJobFactory.newEntity();
	}


	public Object getEntity() {
		return entity;
	}
}
