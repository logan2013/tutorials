import {Directive, ViewContainerRef, ComponentFactoryResolver} from "@angular/core";
@Directive({
  selector: "[tab-content]"
})
export class TabContentDirective {

  constructor(private _viewContainerRef: ViewContainerRef, private _componentFactoryResolver: ComponentFactoryResolver) {
  }

  renderTabContent(actClass: any) {
    this._viewContainerRef.clear();
    let actComponentFactory = this._componentFactoryResolver.resolveComponentFactory(actClass);
    let actComponentRef = this._viewContainerRef.createComponent(actComponentFactory);
  }
}
