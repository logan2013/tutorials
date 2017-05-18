/**
 * Created by Administrator on 2017/5/10.
 */
import {Component, Input, Output, OnInit, EventEmitter} from '@angular/core';

@Component({
    selector:'childOther-view0510',
    template:` 

    <div>
        <span>0510 子页面 </span>
        <br>
        <span>该属性默认值为：paramIn Initial，接收parent传入后为：{{paramIn}} </span>
        <br>
        <span>该属性默认值为：paramIn Initial2，接收parent传入后为：{{paramIn2}} </span>
        <br>
        <button (click)="childClickEvent($event)"> 测试OutPut按钮</button>
        <br>
    </div>
    <br>
    <div *ngFor="let value of numDatas">
      ngFor循环测试：<span>{{value.name}} 年龄：{{value.age}}</span>
    </div> 
    
    `,
})

export class ComponentChild0510 implements OnInit{
    childName : string = 'childName initial';
    childOutName : string = 'childName for output';

    //INPUT表示该属性接受输入
    @Input() paramIn : string = "paramIn Initial";
    @Input() paramIn2 : string = "paramIn Initial2";

    @Output() paramOut : EventEmitter<string> = new EventEmitter<string>();

    numDatas:IChildren[]=[];
    constructor(){
    }

    ngOnInit(){
      this.childName = 'child Name';
      this.numDatas.push({age:0, name:'小孩A'});
      this.numDatas.push({age:1, name:'小孩B'});
      this.numDatas.push({age:2, name:'小孩C'});
    }

    childClickEvent($event) {
        this.paramOut.emit(this.childOutName);
    }

}


interface IChildren{
    age?:number;
    name:string;
}
