package de.kla.spring.bug.autowire.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Component;

import de.kla.spring.bug.autowire.ServiceInvoker;

@Component
public class DefaultJobDetailFactory extends MethodInvokingJobDetailFactoryBean {

	/**
	 * @return name of the job
	 */
	protected String getJobName() {
		return "DefaultJobName";
	}

	@Autowired
	private ServiceInvoker targetObject;

	/**
	 * Gets executed after creation of the bean.
	 */
	@PostConstruct
	public void init() {
		super.setTargetObject(targetObject);
		super.setTargetMethod("invoke");
		super.setArguments(new Object[] { getJobName() });
	}
}
