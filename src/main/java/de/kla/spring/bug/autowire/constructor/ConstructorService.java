package de.kla.spring.bug.autowire.constructor;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.kla.spring.bug.autowire.job.SpecificTrigger;

@Service
public class ConstructorService {

	private final SpecificTrigger trigger;

	@Autowired
	public ConstructorService(SpecificTrigger trigger) {
		Assert.notNull(trigger, "trigger must not be null");

		this.trigger = trigger;
	}

	public JobDetail getJobDetail() {
		return trigger.getJobDetail();
	}
}
