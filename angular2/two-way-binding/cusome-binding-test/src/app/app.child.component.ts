import {Component, Input, Output, EventEmitter} from "@angular/core";
/**
 * Created by Administrator on 2016/12/14.
 */

@Component({
  selector: "countercomponent",
  template: `
<button (click)='increment()'>Increment</button>
    {{count}}
<button (click)='decrement()'>Decrement</button>
`
})
export class AppChildComponent {

  count: number = 0;

  /**
   * 定义一个事件发射器，使用@Output注解可以将事件发射到消费组件（此处为AppComponent）
   */
  @Output() counterChange: EventEmitter<number>;

  constructor() {
    this.counterChange = new EventEmitter();
  }

  /**
   * 使用@Input注解，组件的消费者（此处为AppComponent）可以通过属性绑定来绑定这个变量
   *
   * @returns {number}
   */
  @Input()
  get counter() {
    return this.count;
  }

  increment() {
    this.count = this.count + 1;
    this.counterChange.emit(this.count);
  }

  decrement() {
    this.count = this.count - 1;
    this.counterChange.emit(this.count);
  }
}
