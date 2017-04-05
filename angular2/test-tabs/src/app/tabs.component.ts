import {Component, ContentChildren, QueryList, ComponentFactoryResolver} from '@angular/core';
import {TabComponent} from './tab.component';
import {SharedService} from "./shared.service";
import {TabItemData} from "./tab-item-data";

@Component({
  selector: 'tabs',
  templateUrl: './tabs.component.html'
})
export class TabsComponent {

  tabsForOpItems: TabItemData[] = [];

  constructor(private _sharedService: SharedService) {

    this._sharedService.selectOp$.subscribe(opItem => this.selectTabFromOp(opItem));
  }

  selectTabFromOp(opItem: TabItemData) {
    this.tabsForOpItems.push(opItem);
  }

  /**
   * 选择tab
   * @param tab
   */
  selectTab() {

  }

  /**
   * 关闭tab
   *
   * @param tab
   */
  closeTab() {

  }
}
