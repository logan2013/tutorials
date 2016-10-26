package com.imtzp.akka;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;

public class HappyBdayActorTest {

	private static ActorSystem system;

	private static MessageHandlerService messageHandlerService;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
		messageHandlerService = Mockito.mock(MessageHandlerService.class);
	}

	@AfterClass
	public static void teardown() {
		JavaTestKit.shutdownActorSystem(system);
		system = null;
	}

	@Test
	public void testProps() {

		Props props = HappyBdayActor.props(messageHandlerService);

		Assert.assertThat(props.actorClass(), Matchers.is(Matchers.equalTo(HappyBdayActor.class)));
	}

	@Test
	public void testEventLoggerActorFirebaseRequestMatch() {
		TestProbe probe = TestProbe.apply(system);
		final Props props = HappyBdayActor.props(messageHandlerService);
		Mockito.when(messageHandlerService.substr("RahulKumar", 5)).thenReturn(String.valueOf("Kumar"));
		final TestActorRef<HappyBdayActor> happyBdayActorTestActorRef = TestActorRef.create(system, props);
		happyBdayActorTestActorRef.tell("RahulKumar", happyBdayActorTestActorRef);
		probe.expectNoMsg();
	}
}
