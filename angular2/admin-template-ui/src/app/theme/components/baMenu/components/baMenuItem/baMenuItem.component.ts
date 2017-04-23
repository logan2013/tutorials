import {Component, Input, Output, EventEmitter} from '@angular/core';

import 'style-loader!./baMenuItem.scss';
import {BaMenuService} from "../../../../services/baMenu/baMenu.service";

@Component({
  selector: 'ba-menu-item',
  templateUrl: './baMenuItem.html'
})
export class BaMenuItem {

  @Input() menuItem:any;
  @Input() child:boolean = false;

  @Output() itemHover = new EventEmitter<any>();
  @Output() toggleSubMenu = new EventEmitter<any>();

  constructor(private _menuService: BaMenuService) {
  }

  public onHoverItem($event):void {
    this.itemHover.emit($event);
  }

  public onToggleSubMenu($event, item):boolean {
    $event.item = item;
    this.toggleSubMenu.emit($event);
    return false;
  }

  public onSelectItem($event, item) {
    this._menuService.publishData(item);
  }
}
