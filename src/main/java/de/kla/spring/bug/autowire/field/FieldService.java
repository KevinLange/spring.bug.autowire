package de.kla.spring.bug.autowire.field;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kla.spring.bug.autowire.job.SpecificTrigger;
import de.kla.spring.bug.autowire.job.base.DefaultSchedulerFactory;

@Component
public class FieldService extends DefaultSchedulerFactory {

	@Autowired
	private SpecificTrigger		trigger;

	public JobDetail getJobDetail() {
		return trigger.getJobDetail();
	}

	@Override
	protected Trigger getCustomTrigger() {
		return trigger;
	}

}
