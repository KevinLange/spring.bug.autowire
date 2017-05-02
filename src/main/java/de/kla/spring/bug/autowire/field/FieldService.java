package de.kla.spring.bug.autowire.field;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kla.spring.bug.autowire.job.DefaultJobDetailFactory;

@Service
public class FieldService {

	@Autowired
	private DefaultJobDetailFactory springJobFactory;

	private Object entity;

	@PostConstruct
	public void init() {
		entity = springJobFactory.getObject();
	}

	public Object getEntity() {
		return entity;
	}
}
