import {Component, Input, OnInit, ViewChild} from "@angular/core";
import {CallParentClass} from "./testCalTheParentClass/testCalTheParentClass.component";

@Component({
  selector: 'zzh',
  template: '<div>你好！这是父组件,显示子组件2memberID={{userId}} 父组件age={{userAge}} <button (click)="updateUserAge()">父组件Input子组件1的Age</button></div> ' +
  '<div>通过组件2改变父组件userPhone={{userPhone}}</div>' +
  '<br> <testSubModule [memberAge]="userAge"></testSubModule>' +
  '<br> <test-call-parent-class (updateChildPhone)="onChildClick($event)"></test-call-parent-class>'

})

export  class ComponentZzh implements  OnInit {
  userName: string = 'ComponentZzh';
  userId: number = -1;
  userAge: number = 18;
  userPhone: number = -1;
  @ViewChild(CallParentClass) callTheParentClass: CallParentClass;
  ngOnInit(): void {
    this.userId = this.callTheParentClass.memberId;
  }

  updateUserAge(){
    this.userAge = 25;
  }

  onChildClick(memberPhone: number){
      this.userPhone = memberPhone;
  }

}
