import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ComponentZzh} from "../zzh.component";
import {TestSubModuleComponent} from "./subModule.component";

@NgModule({
  imports: [CommonModule, ComponentZzh],
  declarations: [TestSubModuleComponent],
  entryComponents: [TestSubModuleComponent]
})


export class TestModule{}
