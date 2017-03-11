package main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import child1.ChildContext1;
import child2.ChildContext2;
import root.RootContext;

public class MainApplication {

	public static void main(String[] args) {

		SpringApplicationBuilder appBuilder = new SpringApplicationBuilder().parent(RootContext.class)
				.child(ChildContext1.class).sibling(ChildContext2.class);

		/**
		 * 返回的是ChildContext2
		 */
		ConfigurableApplicationContext applicationContext = appBuilder.run();
		applicationContext.setId("child2");
		((ConfigurableApplicationContext) applicationContext.getParent()).setId("root");

		for (String bdn : applicationContext.getBeanDefinitionNames()) {
			System.out.println("bdn = " + bdn);
		}
	}
}
