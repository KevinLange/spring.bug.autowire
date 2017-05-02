package de.kla.spring.bug.autowire.constructor;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ConstructorService {

	private final MethodInvokingJobDetailFactoryBean springJobFactory;

	private Object entity;

	public ConstructorService(MethodInvokingJobDetailFactoryBean springJobFactory) {
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
