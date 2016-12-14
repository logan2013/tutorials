import {Component} from "@angular/core";
/**
 * Created by Administrator on 2016/12/7.
 */
@Component({
  selector: "springone-header",
  template: `<h1>{{title}}</h1>
   <a routerLink="/greet">Greet</a>
   <a routerLink="/thanks">Thanks</a>
  `
})
export class HeaderComponent {
  title: string = "Welcome to SpringOne Platform";
}
