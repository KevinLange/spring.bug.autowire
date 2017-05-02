package de.kla.spring.bug.autowire.job.base;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;
import org.springframework.util.Assert;

public abstract class DefaultTrigger extends SimpleTriggerBean {

	private static final long serialVersionUID = 1714920723449412318L;

	private static final int	DEFAULT_REPEAT_INTERVAL	= 300000;
	private static final int	DEFAULT_START_DELAY		= 10000;

	private final MethodInvokingJobDetailFactoryBean jobDetailFactory;

	public DefaultTrigger(MethodInvokingJobDetailFactoryBean jobDetailFactory) {
		Assert.notNull(jobDetailFactory, "jobDetailFactory must not be null");

		this.jobDetailFactory = jobDetailFactory;
	}

	protected long getCustomStartDelay() {
		return DEFAULT_START_DELAY;
	}

	protected long getCustomRepeatInterval() {
		return DEFAULT_REPEAT_INTERVAL;
	}

	/**
	 * Gets executed after creation of the bean.
	 */
	@PostConstruct
	public void init() {
		setJobDetail(jobDetailFactory.getObject());
		setStartDelay(getCustomStartDelay());
		setRepeatInterval(getCustomRepeatInterval());
	}
}
