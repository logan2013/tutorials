import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[ad-host]',
})
export class OpDirective {
  constructor(public viewContainerRef: ViewContainerRef) {
  }
}
