import {Component, ContentChildren, QueryList, AfterViewInit, Input, EventEmitter, Output} from "@angular/core";
import {TabComponent} from "./tab.component";
@Component({
  selector: "tabset",
  template: `
  <div>
    <a *ngFor="let tab of tabs" (click)="activateTab(tab)" [class.active]="tab.active">
      {{tab.title}}
      <span (click)="closeTabFn(tab.title)">X</span>
    </a>
  </div>
 
  <ng-content></ng-content>
  `
})
export class TabsetComponent {

  @ContentChildren(TabComponent) tabs: QueryList<TabComponent>;

  @Output() closeTab: EventEmitter<any> = new EventEmitter();

  activateTab(tab:TabComponent) {
    this.tabs.forEach(tab => tab.active = false);
    tab.active = true;
  }

  closeTabFn(title) {
    this.closeTab.emit(title);
  }
}
