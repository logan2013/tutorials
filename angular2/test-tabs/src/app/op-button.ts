import {Component, Input} from "@angular/core";
import {SharedService} from "./shared.service";
import {TabItemData} from "./tab-item-data";

@Component({
  selector: 'op-button',
  template: `
    <button (click)="selectOp()">{{opItem.title}}</button>
  `
})
export class OpButton {

  @Input() opItem: TabItemData;

  constructor(private _sharedService: SharedService) {
  }

  selectOp() {
    this._sharedService.publishData(this.opItem);
  }
}
