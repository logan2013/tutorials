package com.imtzp.akka.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Throwable {
		if (msg instanceof WhoToGreet) {
			System.out.println("hello " + ((WhoToGreet) msg).getWho());
		} else {
			unhandled(msg);
		}
	}

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create();
		
		// Create the greeter actor
		ActorRef greeter = system.actorOf(Props.create(Greeter.class), "greeter");
		
		// Tell the greeter to change its greeting message
		greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());
	}
}
