package de.kla.spring.bug.autowire.job.base;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class DefaultTaskExecutor extends ThreadPoolTaskExecutor {

	private static final long serialVersionUID = 5702412486768662029L;

	private static final int	DEFAULT_CORE_POOL_SIZE		= 10;
	private static final int	DEFAULT_MAX_POOL_SIZE		= 20;
	private static final int	DEFAULT_QUEUE_CAPACITY		= 10;
	private static final int	DEFAULT_KEEP_ALIVE_SECONDS	= 7200;

	public int getCustomCorePoolSize() {
		return DEFAULT_CORE_POOL_SIZE;
	}

	public int getCustomQueueCapacity() {
		return DEFAULT_QUEUE_CAPACITY;
	}

	public int getCustomMaxPoolSize() {
		return DEFAULT_MAX_POOL_SIZE;
	}

	public int getCustomKeepAliveSeconds() {
		return DEFAULT_KEEP_ALIVE_SECONDS;
	}

	@PostConstruct
	public void init() {
		super.setCorePoolSize(getCustomCorePoolSize());
		super.setMaxPoolSize(getCustomMaxPoolSize());
		super.setQueueCapacity(getCustomQueueCapacity());
		super.setKeepAliveSeconds(getCustomKeepAliveSeconds());
	}
}
