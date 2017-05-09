/**
 * Created by Administrator on 2017/4/20.
 */
import {Component} from "@angular/core";
import {BaMenuService} from "../../services/baMenu/baMenu.service";

export interface TopMenu{
  title: string;
  path: string;
}

@Component({
  selector: 'NavTop',
  styleUrls: ['./baNavTop.scss'],
  templateUrl: './baNavTop.html',
})
export class BaNavTop {

  topMenus: TopMenu[] = [];

  constructor(private baMenuService: BaMenuService){}

  ngOnInit(){
    this.baMenuService.topItems.subscribe(this.updateTopMenu.bind(this));
  }

  updateTopMenu(newTopMemus: TopMenu[]){
    this.topMenus = newTopMemus;
  }

  switchMenu(path: string){
    this.baMenuService.fillSiderbarMenu(path);
  }

}

