import {Component} from "@angular/core";
import {TabComponent} from "../tab.component";
import {Act1DetailComponent} from "./act1-detail.component";

@Component({
  selector: "act1",
  template: `
    <div>功能1</div>
    
    <button (click)="goToDetail()">详情</button>
  `
})
export class Act1Component {

  constructor(private tabComponent: TabComponent) {
  }

  goToDetail() {
    this.tabComponent.renderComponent(Act1DetailComponent);
  }
}
