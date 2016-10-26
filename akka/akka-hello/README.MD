https://dzone.com/articles/akka-with-java

https://dzone.com/articles/working-with-akka-actors

https://dzone.com/articles/concurrency-with-akka

1. Actor System: is a glue that wires Actor s, ActorRef s, Dispatcher s and Mailbox es together. Programmers use the ActorSystem to configure the desired implementation of each of these components. It creates and initializes actors.

2. Next, the actor creation process is initiated by Sender(usually itself), which invokes actorOf() on ActorSystem and creates a reference of an Actor object. At this time the Actor my not be created/initiated. ActorRef acts as a proxy to the Actor object and provides an interface to communicate with the Actor

3. Then Sender Actor(Caller - in this case 'actor itself from step2') uses !(bang operator known as tell message pattern - "fire-and-forget,") e.g.send a message asynchronously and return immediately) to tell the receiving Actor about the event (Hi Actor, Can you please process this event?).

4. ActorRef in response dispatches the event on MessageDispatcher(you can configure ActionSystem to use specific dispatcher by invoking withDispatcher)

5. MessageDispatcher enqueue the event to the MessageQueue.
	1). A MessageQueue is one of the core components in forming an Akka MailBox
	2). MessageQueue is where the normal messages that are sent to Actors will be enqueued(and subsequently dequeued)
	3). MessageQueue.enqueue() – enqueue the message to this queue, or throw an exception.
	
6. MessageDispatcher also looks for MailBox(By default every actor has a single mailbox - UnboundedMailbox). The MailBox holds the messages for receiving the Actor. Once it finds the MailBox, MessageDispatcher binds a set of Actors to a thread pool (backed by BlockingQueue) and invokes the MailBox.run() method.

7. MessageQueue.dequeue() – dequeue the next message from this queue, return null failing that.

8. Eventually, MailBox schedules the task on the Actor, which invokes the receive() method on the Actor.