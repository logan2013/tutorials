import {Component} from '@angular/core';

import { BaMenuService } from '../theme';
import { PAGES_MENU } from './pages.menu';

@Component({
  selector: 'pages',
  template: `
    <ba-sidebar></ba-sidebar>
    <ba-page-top></ba-page-top>
    <div class="al-main">
      <div class="al-content">
        <ba-content-top></ba-content-top>
          
        <tabset (closeTab)="closeTab($event)">
  
            <tab *ngFor="let tab of tabs" [actClass]="tab.actClass" [title]="tab.title"></tab>
  
        </tabset>
      </div>
    </div>
    <footer class="al-footer clearfix">
      <div class="al-footer-right" translate>{{'general.created_with'}} <i class="ion-heart"></i></div>
      <div class="al-footer-main clearfix">
        <div class="al-copy">&copy; <a href="http://akveo.com" translate>{{'general.akveo'}}</a> 2016</div>
        <ul class="al-share clearfix">
          <li><i class="socicon socicon-facebook"></i></li>
          <li><i class="socicon socicon-twitter"></i></li>
          <li><i class="socicon socicon-google"></i></li>
          <li><i class="socicon socicon-github"></i></li>
        </ul>
      </div>
    </footer>
    <ba-back-top position="200"></ba-back-top>
    `
})
export class Pages {

  tabs: any[] = [];

  constructor(private _menuService: BaMenuService) {
  }

  ngOnInit() {
    this._menuService.updateMenuByRoutes(PAGES_MENU);
    this._menuService.subscribe((item) => this.openTab(item));
  }

  openTab(item) {
    this.tabs.push({
      actClass: item.actClass,
      title: item.title
    });
  }

  closeTab(title: string) {
    const toClosedTabs:any[] = this.tabs.filter(tab => tab.title === title);
    if (toClosedTabs.length) {
      toClosedTabs.forEach(toClosedTab => this.tabs.splice(this.tabs.indexOf(toClosedTab), 1));
    }
  }
}
