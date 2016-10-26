package com.imtzp.akka.stream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.Done;
import akka.actor.ActorSystem;
import akka.kafka.ConsumerSettings;
import akka.kafka.Subscriptions;
import akka.kafka.javadsl.Consumer;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Sink;

public class Main {

	public static void main(String[] args) {

		Config config = ConfigFactory.load();
		ActorSystem system = ActorSystem.create("akka-stream-kafka-getting-started", config);

		ConsumerSettings<byte[], String> consumerSettings = ConsumerSettings
				.create(system, new ByteArrayDeserializer(), new StringDeserializer())
				.withBootstrapServers("localhost:9092").withGroupId("group1")
				.withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		final DB db = new DB();

		Consumer.committableSource(consumerSettings, Subscriptions.topics("akkaTopic"))
				.mapAsync(1, msg -> db.update(msg.record().value()).thenApply(done -> msg))
				.runWith(Sink.ignore(), ActorMaterializer.create(system));
	}

	static class DB {
		public CompletionStage<Done> update(String data) {
			System.out.println("DB.update: " + data);
			return CompletableFuture.completedFuture(Done.getInstance());
		}
	}

}
