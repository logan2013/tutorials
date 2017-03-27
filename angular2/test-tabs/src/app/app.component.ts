import {Component, OnInit} from '@angular/core';
import {OpService} from "./op.service";
import {OpItem} from "./op-item";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ads: OpItem[];

  constructor(private adService: OpService) {}

  ngOnInit() {
    this.ads = this.adService.getAds();
  }
}
