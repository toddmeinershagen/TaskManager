package com.ansh.test.controller;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ansh.test.dao.UserDao;

public class SpringRestControllerTest {
	
	SpringRestController controller = new SpringRestController();
	
	@Mock
	UserDao dao;
	
	@Before
	public void setup() {
		Mockito.when(dao.getAllUsers()).thenReturn(Arrays.asList("ansh", "jain"));
		
	}
	
	@Test
	public void testSayHello() {
		String response = controller.sayHello();
		Assert.assertEquals("Hello", response);
	}
	
	@Test
	public void testToUpperCase() {
		Assert.assertEquals("ANSH", controller.toUpperCase("ansh"));
	}

}
