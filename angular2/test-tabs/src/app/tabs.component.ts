import {Component, ContentChildren, QueryList} from '@angular/core';
import {TabComponent} from './tab.component';
import {SharedService} from "./shared.service";
import {OpItem} from "./op-item";

@Component({
  selector: 'tabs',
  template: `
    <ul class="nav nav-tabs">
      <li *ngFor="let tab of initTabs" (click)="selectTab(tab)" [class.active]="tab.active">
        <a href="javascript:void(0);">{{tab.title}}</a>
        <span (click)="closeTab(tab)">X</span>
      </li>
      <ng-content></ng-content>
    </ul>
  `
})
export class TabsComponent {

  @ContentChildren(TabComponent) initTabs: QueryList<TabComponent>;

  tabs: TabComponent[];

  constructor(private _sharedService: SharedService) {

    this._sharedService.selectOp$.subscribe(opItem => this.selectTabFromOp(opItem));

    console.log(this.initTabs);
  }

  selectTabFromOp(opItem: OpItem) {
    let tabs: TabComponent[] = this.initTabs.toArray().filter(tab => !tab.title);
    if (tabs.length) {
      tabs[0].title = opItem.title;
      this.selectTab(tabs[0]);
      tabs[0].loadComponent(opItem);
    }
  }

  /**
   * 选择tab
   * @param tab
   */
  selectTab(tab: TabComponent) {

    this.initTabs.toArray().forEach(tab => tab.active = false);

    tab.active = true;
  }

  /**
   * 关闭tab
   *
   * @param tab
   */
  closeTab(tab: TabComponent) {

  }
}
