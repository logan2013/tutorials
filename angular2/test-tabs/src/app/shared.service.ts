import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {TabItemData} from "./tab-item-data";

@Injectable()
export class SharedService {

  private selectOp = new Subject<TabItemData>();

  selectOp$ = this.selectOp.asObservable();

  publishData(opItem: TabItemData) {
    this.selectOp.next(opItem);
  }
}
