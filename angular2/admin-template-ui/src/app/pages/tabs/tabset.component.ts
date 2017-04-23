import {Component, ContentChildren, QueryList, AfterViewInit, Input, EventEmitter, Output, OnInit} from "@angular/core";
import {TabComponent} from "./tab.component";
import {BaMenuService} from "../../theme/services/baMenu/baMenu.service";
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
export class TabsetComponent implements OnInit {

    @ContentChildren(TabComponent) tabs: QueryList<TabComponent>;

    constructor(private _menuService: BaMenuService) {
    }

    @Output() closeTab: EventEmitter<any> = new EventEmitter();

    ngOnInit(): void {
        this._menuService.subscribe((item) => this.tabs.filter(t => t.title != item.title).forEach(tab => tab.active = false));
    }

    activateTab(tab: TabComponent) {
        this.tabs.forEach(tab => tab.active = false);
        tab.active = true;
    }

    deactivateTabs() {
        this.tabs.forEach(tab => tab.active = false);
    }

    closeTabFn(title) {
        this.closeTab.emit(title);
    }
}
