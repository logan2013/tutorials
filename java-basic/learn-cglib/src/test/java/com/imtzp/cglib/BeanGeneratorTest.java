package com.imtzp.cglib;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import net.sf.cglib.beans.BeanGenerator;

public class BeanGeneratorTest {

	@Test
	public void givenBeanCreator_whenAddProperty_thenClassShouldHaveFieldValue() throws Exception {

		BeanGenerator beanGenerator = new BeanGenerator();

		beanGenerator.addProperty("name", String.class);

		Object myBean = beanGenerator.create();

		Method setter = myBean.getClass().getMethod("setName", String.class);

		setter.invoke(myBean, "some string value set by a cglib");

		Method getter = myBean.getClass().getMethod("getName");
		Assert.assertEquals("some string value set by a cglib", getter.invoke(myBean));

		System.out.println(myBean.getClass().getName());

	}
}
