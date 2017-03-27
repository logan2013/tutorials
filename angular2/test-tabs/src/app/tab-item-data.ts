import {Type} from '@angular/core';
export class TabItemData {

  constructor(public title: string, public component: Type<any>,  public data: any, public activated: boolean = true) {

  }
}
