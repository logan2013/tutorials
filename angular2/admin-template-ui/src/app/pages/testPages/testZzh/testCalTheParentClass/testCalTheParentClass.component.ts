
import {Component, EventEmitter, OnInit, Output} from "@angular/core";
@Component({
  selector: 'test-call-parent-class',
  template: '<p>这里是子组件2 <button (click)="updatePhone($event)">改变组件2的电话</button></p>'

})

export class CallParentClass implements  OnInit{
  iphone: number = 1882288;
  memberId: number = 196;

  @Output() updateChildPhone: EventEmitter<number> = new EventEmitter<number>();
  ngOnInit(): void {
  }
  updatePhone(iphone){
    this.updateChildPhone.emit(this.iphone);
  }
}

