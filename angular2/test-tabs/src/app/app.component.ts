import {Component, OnInit} from '@angular/core';
import {OpService} from "./op.service";
import {TabItemData} from "./tab-item-data";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ads: TabItemData[];

  constructor(private adService: OpService) {}

  ngOnInit() {
    this.ads = this.adService.getAds();
  }
}
