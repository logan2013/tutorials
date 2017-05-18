/**
 * Created by Administrator on 2017/5/10.
 */
import {Component, OnInit, ViewChild} from '@angular/core';
import {ComponentChild0510} from "./0510Child.component";

@Component({
    selector:'newSelector0510',
    template:`
      <div>父组件自身属性</div>
      <div>
         
        
      </div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <childOther-view0510 [paramIn]="child" [paramIn2]="child2"(paramOut)="outputAccpt($event)"></childOther-view0510>
    `,
})

export class Component0510 implements OnInit{

    //直接查看子组建的属性的值
    @ViewChild(ComponentChild0510) childComponent : ComponentChild0510;

    //该属性作为参数传递给子组建
    child : string;
    child2 : string;

    constructor(){
    }

    ngOnInit(){
        console.log("父COMPONENT打印子属性COMPONENT的值：" + this.childComponent.childName);

        alert("父COMPONENT打印子属性COMPONENT的值：" + this.childComponent.childName);



        this.child = 'paramIn Father';
        this.child2 = 'paramIn Father2';
    }

    outputAccpt(obj) {
        console.log("parent 组建接收到的属性：" + obj);
    }
}
