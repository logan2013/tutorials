import {NgModule}      from '@angular/core';
import {CommonModule}  from '@angular/common';

import {NgaModule} from '../theme/nga.module';
import {AppTranslationModule} from '../app.translation.module';

import {Pages} from './pages.component';
import {TabsModule} from "./tabs/tabs.module";
import {DashboardModule} from "./dashboard/dashboard.module";
import {ChartsModule} from "./charts/charts.module";
import {ComponentsModule} from "./components/components.module";
import {EditorsModule} from "./editors/editors.module";
import {FormsModule} from "./forms/forms.module";
import {MapsModule} from "./maps/maps.module";
import {TablesModule} from "./tables/tables.module";
import {UiModule} from "./ui/ui.module";

@NgModule({
  imports: [
    CommonModule, AppTranslationModule, NgaModule,
    TabsModule, ChartsModule, ComponentsModule,
    DashboardModule, EditorsModule,
    FormsModule, MapsModule, TablesModule, UiModule],
  declarations: [Pages]
})
export class PagesModule {
}
