package de.kla.spring.bug.autowire.job;

import org.springframework.stereotype.Component;

import de.kla.spring.bug.autowire.job.base.DefaultJobDetailFactory;

@Component
public class SpecificJobDetailFactory extends DefaultJobDetailFactory {

	private static final String JOB_NAME = "specificJob";

	@Override
	protected String getJobName() {
		return JOB_NAME;
	}
}
