import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {OpItem} from "./op-item";

@Injectable()
export class SharedService {

  private selectOp = new Subject<OpItem>();

  selectOp$ = this.selectOp.asObservable();

  publishData(opItem: OpItem) {
    this.selectOp.next(opItem);
  }
}
