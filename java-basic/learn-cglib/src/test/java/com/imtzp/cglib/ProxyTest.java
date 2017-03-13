package com.imtzp.cglib;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.imtzp.cglib.proxy.PersonService;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

public class ProxyTest {

	@Test
	public void givenPersonService_whenSayHello_thenReturnResult() {

		PersonService personService = new PersonService();

		String res = personService.sayHello("Tom");

		assertEquals(res, "Hello Tom");
	}

	@Test
	public void givenEnhancerProxy_whenExtendPersonService_thenInterceptMethod() throws Exception {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);

		enhancer.setCallback((FixedValue) () -> "Hello Tom!");

		PersonService proxy = (PersonService) enhancer.create();

		String res = proxy.sayHello(null);

		assertEquals(res, "Hello Tom!");

		try {
			proxy.lengthOfName("hello");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof ClassCastException);
		}
	}

	@Test
	public void givenEnhancer_whenExecuteMethodOnProxy_thenInterceptOnlyStringReturnTypeMethod() {

		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
			if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
				return "Hello Tom!";
			} else {
				return proxy.invokeSuper(obj, args);
			}
		});

		PersonService proxy = (PersonService) enhancer.create();
		assertEquals("Hello Tom!", proxy.sayHello(null));
		int lengthOfName = proxy.lengthOfName("Mary");
		assertEquals(4, lengthOfName);
	}

}
