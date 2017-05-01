package de.kla.spring.bug.autowire.constructor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJunit4ClassRunner.class)
public class ConstructorServiceTest {

	@Autowired
	ConstructorService sut;
	
	@Before
	public void setUp() {
		Assert.assertNotNull(sut);
	}
	
	
	@Test
	public void newInstanceIsSet() {
		Assert.assertNotNull("entity is expected to be notNull", sut.getEntity());
	}
	
}
