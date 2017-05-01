package de.kla.spring.bug.autowire.field;

import javax.annotation.PostConstruct;

import org.junit.Assert;

import de.kla.spring.bug.autowire.SpringJobFactory;

@Service
public class FieldService {

	@Autowired
	private SpringJobFactory springJobFactory;
	private Object entity;

	@PostConstruct
	public void init() {
		entity = springJobFactory.newEntity();
	}

	public Object getEntity() {
		return entity;
	}
}
