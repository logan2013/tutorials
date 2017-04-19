import {Component, Input, Output, EventEmitter} from '@angular/core';

import 'style-loader!./baMenuItem.scss';

@Component({
  selector: 'ba-menu-item',
  templateUrl: './baMenuItem.html'
})
export class BaMenuItem {

  @Input() menuItem:any;
  @Input() child:boolean = false;

  @Output() itemHover = new EventEmitter<any>();
  @Output() toggleSubMenu = new EventEmitter<any>();
  @Output() selectItem = new EventEmitter<any>();

  public onHoverItem($event):void {
    this.itemHover.emit($event);
  }

  public onToggleSubMenu($event, item):boolean {
    $event.item = item;
    this.toggleSubMenu.emit($event);
    return false;
  }

  public onSelectItem1($event, item) {

    console.log("event in baMenuItem");
    console.log(item);

    this.selectItem.emit(item);
    return false;
  }

  public onSelectItem2($event) {

    console.log("event in baMenuItem menu");
    console.log($event);

    this.selectItem.emit($event);
    return false;
  }
}
