package com.imtzp.cglib;

import org.junit.Assert;
import org.junit.Test;

import com.imtzp.cglib.mixin.Class1;
import com.imtzp.cglib.mixin.Class2;
import com.imtzp.cglib.mixin.Interface1;
import com.imtzp.cglib.mixin.Interface2;
import com.imtzp.cglib.mixin.MixinInterface;

import net.sf.cglib.proxy.Mixin;

public class MixinTest {

	@Test
	public void givenTwoClasses_whenMixedIntoOne_thenMixinShouldHaveMethodsFromBothClasses() {

		Mixin mixin = Mixin.create(new Class[] { Interface1.class, Interface2.class, MixinInterface.class },
				new Object[] { new Class1(), new Class2() });

		MixinInterface mixinDelegate = (MixinInterface) mixin;

		Assert.assertEquals("first behaviour", mixinDelegate.first());
		Assert.assertEquals("second behaviour", mixinDelegate.second());
	}
}
