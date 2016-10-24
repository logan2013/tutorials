package com.imtzp.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.DeciderBuilder;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class Supervisor extends AbstractActor {

	protected final LoggingAdapter logger = Logging.getLogger(context().system(), this);

	public static final String BEAN_NAME = "supervisor";

	public static Props props() {
		return Props.create(Supervisor.class);
	}

	private final SupervisorStrategy strategy = new OneForOneStrategy(false,
			DeciderBuilder.match(InterruptedException.class, e -> SupervisorStrategy.resume())
					.match(Throwable.class, e -> SupervisorStrategy.restart()).build());

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}

	@Override
	public PartialFunction<Object, BoxedUnit> receive() {
		return ReceiveBuilder.match(Props.class, props -> {
			sender().tell(context().actorOf(props), ActorRef.noSender());
		}).matchAny(msg -> logger.error("Unknown message: {}", msg)).build();
	}
}
