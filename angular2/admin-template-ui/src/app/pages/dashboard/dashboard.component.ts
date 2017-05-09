import {Component} from '@angular/core';
import {TabComponent} from "../../theme/components/tabs/tab.component";
import {DashboardDetail} from "./dashboard-detail.component";

@Component({
  selector: 'dashboard',
  styleUrls: ['./dashboard.scss'],
  templateUrl: './dashboard.html'
})
export class Dashboard {

  constructor(private tab: TabComponent) {
  }

  goToDetail() {
    this.tab.renderComponent(DashboardDetail);
  }
}
