import {
  Component, Input, AfterContentInit, ViewChild
} from "@angular/core";
import {TabContentDirective} from "../../directives";

@Component({
  selector: "tab",
  styleUrls:["./tab.scss"],
  template: `
  <div [ngStyle]="{display: active ? 'block':'none'}" class="card-body card tab clearfix">
    <ng-template tab-content></ng-template>
  </div>
  `
})


export class TabComponent implements AfterContentInit {

  @Input() actClass: any;

  @Input() title: string;

  @Input() active: boolean = true;

  @ViewChild(TabContentDirective) tabContentDirective: TabContentDirective;

  ngAfterContentInit(): void {
    this.tabContentDirective.renderTabContent(this.actClass);
  }

  /**
   * Tab中打开新的component
   *
   * @param actClass
   */
  renderComponent(actClass: any) {
    this.tabContentDirective.renderTabContent(actClass);
  }
}
