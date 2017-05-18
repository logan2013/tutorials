import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ComponentZzh} from "./zzh.component";
import {TestSubModuleComponent} from "./testSubModule/subModule.component";
import {CallParentClass} from "./testCalTheParentClass/testCalTheParentClass.component";

@NgModule({
  imports: [CommonModule],
  declarations: [ComponentZzh, TestSubModuleComponent, CallParentClass],
  entryComponents: [ComponentZzh]
})


export  class  ModuleZzh{}
