import {
  Component, Input, AfterContentInit, ViewChild
} from "@angular/core";
import {TabContentDirective} from "./tab-content.directive";

@Component({
  selector: "tab",
  template: `
    <ng-template tab-content></ng-template>
  `
})
export class TabComponent implements AfterContentInit {

  @Input() actClass: any;

  @Input() title: string;

  active: boolean;

  @ViewChild(TabContentDirective) tabContentDirective: TabContentDirective;

  ngAfterContentInit(): void {
    this.tabContentDirective.renderTabContent(this.actClass);
  }

  renderComponent(actClass: any) {
    this.tabContentDirective.renderTabContent(actClass);
  }
}
