import { Component } from '@angular/core';
import {Act1Component} from "./acts/act1.component";

@Component({
  selector: 'app-root',
  template: `
  <h1>
    {{title}}
  </h1>
  
  <tabset (closeTab)="closeTab($event)">
  
  <div *ngFor="let tab of tabs" >
    <tab [actClass]="tab.actClass" [title]="tab.title"></tab>
  </div>
  
  </tabset>
  `,
  styles: []
})
export class AppComponent {
  title = 'app works!';

  tabs: any[] = [];

  constructor() {
    this.tabs.push({
      actClass: Act1Component,
      title: "功能1标题"
    });
  }

  closeTab(title: string) {
    const toClosedTabs:any[] = this.tabs.filter(tab => tab.title === title);
    if (toClosedTabs.length) {
      toClosedTabs.forEach(toClosedTab => this.tabs.splice(this.tabs.indexOf(toClosedTab), 1));
    }
  }
}
