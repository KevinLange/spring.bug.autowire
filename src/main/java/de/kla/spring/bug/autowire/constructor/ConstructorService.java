package de.kla.spring.bug.autowire.constructor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.kla.spring.bug.autowire.job.DefaultJobDetailFactory;

@Service
public class ConstructorService {

	private final DefaultJobDetailFactory springJobFactory;

	private Object entity;

	@Autowired
	public ConstructorService(DefaultJobDetailFactory springJobFactory) {
		Assert.notNull(springJobFactory, "springJobFactory must not be null");

		this.springJobFactory = springJobFactory;
	}

	@PostConstruct
	public void init() {
		entity = springJobFactory.getObject();
	}

	public Object getEntity() {
		return entity;
	}
}
