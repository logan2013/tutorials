///<reference path="../theme/services/baMenu/baMenu.service.ts"/>
import {Component} from "@angular/core";

@Component({
  selector: 'pages',
  template: `
    <ba-sidebar></ba-sidebar>
    <ba-page-top></ba-page-top>
    <tzb-QuitTop></tzb-QuitTop>
    <div class="al-main">
      <div class="al-content">
        <!--<ba-content-top></ba-content-top>-->
        <tabset (closeTab)="closeTab($event)">
        </tabset>
      </div>
    </div>
  <!--  <footer class="al-footer clearfix">
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
    </footer>-->
    <ba-back-top position="200"></ba-back-top>
    `
})
export class Pages {
}
