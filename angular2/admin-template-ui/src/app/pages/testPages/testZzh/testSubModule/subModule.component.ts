

import {Component, Input, OnInit} from "@angular/core";
import {ComponentZzh} from "../zzh.component";
@Component({
  selector: 'testSubModule',
  template: '  <div> 你好！这是子组件1,这是父组件userName={{memberName}} 父组件年龄：{{memberAge}}</div>  '
})

export class TestSubModuleComponent implements OnInit{
  @Input() memberAge: number = -1;
  memberName: string = '';
  constructor(private componentZzh: ComponentZzh){

  }

  ngOnInit(): void {
    this.memberName = this.componentZzh.userName;
  }

}
