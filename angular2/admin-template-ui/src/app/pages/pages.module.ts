import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';

import { NgaModule } from '../theme/nga.module';
import { AppTranslationModule } from '../app.translation.module';

import { Pages } from './pages.component';
import {TabsModule} from "./tabs/tabs.module";
import {Dashboard} from "./dashboard/dashboard.component";
import {DashboardModule} from "./dashboard/dashboard.module";

@NgModule({
  imports: [CommonModule, AppTranslationModule, NgaModule, TabsModule, DashboardModule],
  declarations: [Pages],
  entryComponents: [
      Dashboard
  ]
})
export class PagesModule {
}
