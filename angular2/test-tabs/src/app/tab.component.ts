import {
  Component, Input, ViewChild, ComponentFactoryResolver
} from '@angular/core';
import {OpDirective} from "./op.directive";
import {OpItem} from "./op-item";
import {OpComponent} from "./op.component";

@Component({
  selector: 'tab',
  styles: [`
    .pane{
      padding: 1em;
    }
  `],
  template: `
    <div [hidden]="!active" class="pane">
      <ng-template ad-host></ng-template>
    </div>
  `
})
export class TabComponent {

  @Input('tabTitle') title: string;
  @Input() active = false;

  @ViewChild(OpDirective) adHost: OpDirective;

  constructor(private _componentFactoryResolver: ComponentFactoryResolver) {
  }

  loadComponent(opItem: OpItem) {

    let componentFactory = this._componentFactoryResolver.resolveComponentFactory(opItem.component);
    let viewContainerRef = this.adHost.viewContainerRef;
    viewContainerRef.clear();
    let componentRef = viewContainerRef.createComponent(componentFactory);
    (<OpComponent>componentRef.instance).data = opItem.data;
  }
}
