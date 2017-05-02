package de.kla.spring.bug.autowire.job.base;

import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public abstract class DefaultSchedulerFactory extends SchedulerFactoryBean {

	@Autowired
	private DefaultTaskExecutor defaultTaskExecutor;

	/**
	 * @return the trigger to use
	 */
	protected abstract Trigger getCustomTrigger();

	protected Executor getCustomTaskExecutor() {
		return defaultTaskExecutor;
	}

	/**
	 * Gets executed after creation of the bean.
	 */
	@PostConstruct
	public void init() {
		super.setTriggers(getCustomTrigger());
		super.setTaskExecutor(getCustomTaskExecutor());
	}
}
