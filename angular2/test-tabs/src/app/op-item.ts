import {Type} from '@angular/core';
export class OpItem {

  constructor(public title: string, public component: Type<any>, public data: any) {

  }
}
