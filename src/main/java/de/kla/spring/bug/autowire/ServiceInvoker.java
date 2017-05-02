package de.kla.spring.bug.autowire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceInvoker {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void invoke(String str) {
		logger.info("Entering invoke(str={})", str);
	}
}
