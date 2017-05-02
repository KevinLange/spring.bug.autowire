package de.kla.spring.bug.autowire.field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.kla.spring.bug.autowire.constructor.ConstructorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class FieldServiceTest {

	@Autowired
	private ConstructorService sut;

	@Before
	public void setUp() {
		Assert.assertNotNull(sut);
	}

	@Test
	public void newInstanceIsSet() {
		Assert.assertNotNull("entity is expected to be notNull", sut.getEntity());
	}
}
