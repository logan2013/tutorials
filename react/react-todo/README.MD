https://dzone.com/articles/how-reactjs-is-even-more-powerful-if-you-use-flux-1

1. npm卸载依赖
npm uninstall 依赖名

2. Flux
. Views "Dispatch" "Actions".
视图派发动作

. "Store" Responds to Dispatched Events.
Store对派发的事件做出响应

. Store Emits a "Change" Event.
Store发出变动事件

. View Responds to the "Change" Event
视图对变动事件做出响应

. A "dispatcher" is essentially an event system.
派发器本质上是一个事件系统

. There is at most one global dispatcher.
最多能出现一个全局派发器

. “Store” is specific collection of logic and data.
Store是一个包含逻辑和数据的特定集合

. A “Store” is a singleton.
Store是单例的

. A store is not a model. A store contains models.
store不是model，store包含model

. A store is the only entity in the application that is aware of how to update data.
store是应用中唯一意识到如何更新数据的实体

. Only stores registers to dispatcher callbacks. store emits an event, but not using the dispatcher!
只有store会注册派发器的回调，store发出事件，但不是使用派发器

. When store data changes, your views shouldn't care if things were added, deleted, or modified but just re-render.
当store的数据发生变化时，视图不应该关心是否有东西发生了增删改，只需重新渲染