package de.kla.spring.bug.autowire.field;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

	@Autowired
	private MethodInvokingJobDetailFactoryBean springJobFactory;

	private Object entity;

	@PostConstruct
	public void init() {
		entity = springJobFactory.getObject();
	}

	public Object getEntity() {
		return entity;
	}
}
