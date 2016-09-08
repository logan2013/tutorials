package com.imtzp.servlet3;

public class HelloHandleType implements IHelloHandleType {

	@Override
	public void onStartup() {

		System.out.println("invoking HelloHandleType.onStartup");
	}

}
