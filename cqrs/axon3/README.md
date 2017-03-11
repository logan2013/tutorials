axon framework学习

http://www.baeldung.com/axon-cqrs-event-sourcing

. CQRS（Command Query Responsibility Segregation） 


. TargetAggregateIdentifier注解告诉Axon，被注解的字段是给定aggregate的id

. 每个aggregate必须有一个id字段，通过使用AggregateIdentifier注解来指定

. 在这个例子中，当CreateMessageCommand进来的时候aggregate被创建-接受这个command会产生MessageCreatedEvent
这个时候，aggregate处于messageCreated状态。当MarkReadMessageCommand进来时，aggregate产生MessageReadEvent

. 首先，需要创建一个command bus来发送commands
接下来，需要设置一个message bus来发送产生的的event
最后，我们需要定义一个handler，它将注册aggregate产生的events

. Events需要持久化，所以我们需要定义一个repository来保存它们
这个简单的例子里，我们把events保存到内存中。在生产系统中，当然应该保存到数据库或者其它类型的持久化store

. 如果我们做Event Sourcing，EventStore将是框架的核心。所有aggregate产生的事件都需要持久化到store中，保留所有变化的一行主要的记录在系统中。

. Event是不可变的，因此一旦被保存到event store，它们不能被修改或者删除。利用这些事件我们可以重建在某个时间点系统的状态。只需获取到这个时间点为止所有发生的event




