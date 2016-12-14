import {Component, Input, OnInit} from "@angular/core";
import {GreeterService} from "./greeter.service";
/**
 * Created by Administrator on 2016/12/7.
 */
@Component({
  selector: "greeting",
  template: `Hi {{username}}={{age}}
               <input type="text" [(value)]="username"/>
               <input type="text" [(ngModel)]="username"/>
               <button (click)="onClick()">Save</button>`,
  providers:[GreeterService]
})
export class GreeterComponent implements OnInit{

  age: number = 20;

  constructor(private greeterService: GreeterService) {

  }

  ngOnInit() {
    this.age = this.greeterService.getAge();
  }

  @Input("username") username: string = "Sergi";

  onClick() {
    console.log("click");
  }
}
