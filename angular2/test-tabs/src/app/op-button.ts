import {Component, Input} from "@angular/core";
import {SharedService} from "./shared.service";
import {OpItem} from "./op-item";

@Component({
  selector: 'op-button',
  template: `
    <button (click)="selectOp()">{{opItem.title}}</button>
  `
})
export class OpButton {

  @Input() opItem: OpItem;

  constructor(private _sharedService: SharedService) {
  }

  selectOp() {
    this._sharedService.publishData(this.opItem);
  }
}
