import {Component, OnInit} from "@angular/core";
import {BaMenuService} from "../../services";
@Component({
    selector: 'tabset',
    styleUrls: ['./tabset.scss'],
    templateUrl: './tabset.html'
})
export class TabsetComponent implements OnInit {

    tabDataArray: any[] = [];

    constructor(private _menuService: BaMenuService) {
    }

    ngOnInit(): void {

      this._menuService.selectOp.subscribe((item) => this.openTab(item));

    }

    activateTab(tab: any) {
      this.tabDataArray.forEach(template => template.active = false);
      tab.active = true;
    }

    openTab(item) {
      let selectedTab = this.tabDataArray.find(tab => tab.title === item.title);
      if (selectedTab){
        this.activateTab(selectedTab);
      }else{

        this.tabDataArray.forEach(tab => tab.active = false);

        this.tabDataArray.push({
          actClass: item.actClass,
          title: item.title,
          active: true
        });

      }
    }

    closeTab(title: string) {
      const toClosedTabs: any[] = this.tabDataArray.filter(tab => tab.title === title);
      if (toClosedTabs.length) {
        toClosedTabs.forEach(toClosedTab => this.tabDataArray.splice(this.tabDataArray.indexOf(toClosedTab), 1));
        if (this.tabDataArray.length){
          this.tabDataArray[this.tabDataArray.length - 1].active = true;
        }
      }
    }

}
