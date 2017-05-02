package de.kla.spring.bug.autowire.field;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kla.spring.bug.autowire.job.SpecificTrigger;

@Service
public class FieldService {

	@Autowired
	private SpecificTrigger trigger;

	public JobDetail getJobDetail() {
		return trigger.getJobDetail();
	}
}
