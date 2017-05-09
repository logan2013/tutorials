import {NgModule}      from '@angular/core';
import {CommonModule}  from '@angular/common';

import {NgaModule} from '../theme/nga.module';

import {Pages} from './pages.component';
import {DashboardModule} from "./dashboard/dashboard.module";
import {ChartsModule} from "./charts/charts.module";
import {ComponentsModule} from "./components/components.module";
import {EditorsModule} from "./editors/editors.module";
import {FormsModule} from "./forms/forms.module";
import {MapsModule} from "./maps/maps.module";
import {TablesModule} from "./tables/tables.module";
import {UiModule} from "./ui/ui.module";
import {TestModule} from "./test/test.module";
import {TestbModule} from "./test2/testb.module";
import { TestModule2 } from './test2/test2.module';
import { TestModule3 } from './test3/test3.module';
import { Test4Module } from './test4/test4.module';




@NgModule({
  imports: [
    CommonModule, NgaModule,
    ChartsModule, ComponentsModule,
    DashboardModule, EditorsModule,
    TestModule,TestModule2,TestModule3,Test4Module,
    FormsModule, MapsModule, TablesModule, UiModule],
  declarations: [Pages]
})
export class PagesModule {
}
