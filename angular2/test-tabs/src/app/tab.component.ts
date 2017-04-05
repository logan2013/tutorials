import {
  Component, Input, ViewChild, ComponentFactoryResolver, OnInit, AfterContentInit, Type
} from '@angular/core';
import {OpDirective} from "./op.directive";
import {TabItemData} from "./tab-item-data";
import {OpComponent} from "./op.component";

@Component({
  selector: 'tab',
  styles: [`
    .pane{
      padding: 1em;
    }
  `],
  template: `
    <div>{{title}}</div>
    <div [hidden]="!active" class="pane">
      <ng-template ad-host></ng-template>
    </div>
  `
})
export class TabComponent implements AfterContentInit {

  @Input() title: string;
  @Input() active = true;
  @Input() component: Type<any>;
  @Input() data: any;

  @ViewChild(OpDirective) adHost: OpDirective;

  constructor(private _componentFactoryResolver: ComponentFactoryResolver) {
  }

  loadComponent() {

    let componentFactory = this._componentFactoryResolver.resolveComponentFactory(this.component);
    let viewContainerRef = this.adHost.viewContainerRef;
    viewContainerRef.clear();
    let componentRef = viewContainerRef.createComponent(componentFactory);
    (<OpComponent>componentRef.instance).data = this.data;
  }

  ngAfterContentInit(): void {
    this.loadComponent();
  }
}
