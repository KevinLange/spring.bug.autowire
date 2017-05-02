package de.kla.spring.bug.autowire.constructor;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import de.kla.spring.bug.autowire.job.SpecificTrigger;
import de.kla.spring.bug.autowire.job.base.DefaultSchedulerFactory;

@Component
public class ConstructorService extends DefaultSchedulerFactory {

	private final SpecificTrigger trigger;

	@Autowired
	public ConstructorService(SpecificTrigger trigger) {
		Assert.notNull(trigger, "trigger must not be null");

		this.trigger = trigger;
	}

	public JobDetail getJobDetail() {
		return trigger.getJobDetail();
	}

	@Override
	protected Trigger getCustomTrigger() {
		return trigger;
	}
}
