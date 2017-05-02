package de.kla.spring.bug.autowire.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kla.spring.bug.autowire.job.base.DefaultTrigger;

@Component
public class SpecificTrigger extends DefaultTrigger {

	private static final long serialVersionUID = -6336412151840036822L;

	@Autowired
	public SpecificTrigger(SpecificJobDetailFactory specificJobDetailFactory) {
		super(specificJobDetailFactory);
	}
}
