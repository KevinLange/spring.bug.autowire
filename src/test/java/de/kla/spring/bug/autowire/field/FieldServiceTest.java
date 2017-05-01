package de.kla.spring.bug.autowire.field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.kla.spring.bug.autowire.constructor.Autowired;
import de.kla.spring.bug.autowire.constructor.ConstructorService;

public class FieldServiceTest {

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
