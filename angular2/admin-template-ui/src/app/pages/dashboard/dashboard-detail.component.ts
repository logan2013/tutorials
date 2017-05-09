import {Component} from "@angular/core";
import {TabComponent} from "../../theme/components/tabs/tab.component";
import {Dashboard} from "./dashboard.component";
@Component({
  selector: "dashboard-detail",
  template: `
        
    <div class="button-wrapper">
      <button type="button" class="btn btn-primary btn-raised" (click)="goBack()">返回</button>
    </div>
    
    <div>DashboardDetail</div>
  `
})
export class DashboardDetail {

  constructor(private tab: TabComponent) {
  }

  goBack() {
    this.tab.renderComponent(Dashboard);
  }
}
