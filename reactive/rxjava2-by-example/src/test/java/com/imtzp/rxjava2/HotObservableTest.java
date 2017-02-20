package com.imtzp.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;

public class HotObservableTest {

	public static void main(String[] args) {
		SomeFeed<PriceTick> feed = new SomeFeed<>();

		Flowable<PriceTick> flowable = Flowable.create(emitter -> {
			SomeListener listener = new SomeListener() {

				@Override
				public void priceTick(PriceTick event) {
					emitter.onNext(event);
					if (event.isLast()) {
						emitter.onComplete();
					}
				}

				@Override
				public void error(Throwable e) {
					emitter.onError(e);
				}
			};

			feed.register(listener);
		} , BackpressureStrategy.BUFFER);

		ConnectableFlowable<PriceTick> hotObservable = flowable.publish();
		hotObservable.connect();

		hotObservable.take(10).subscribe(priceTick -> System.out.printf("1 %s %4s %6.2f%n", priceTick.getDate(),
				priceTick.getInstrument(), priceTick.getPrice()));

		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		hotObservable.take(10).subscribe(priceTick -> System.out.printf("2 %s %4s %6.2f%n", priceTick.getDate(),
				priceTick.getInstrument(), priceTick.getPrice()));
	}
}
