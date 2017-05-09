import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { ChartistJs } from './components/chartistJs/chartistJs.component';
import { ChartistJsService } from './components/chartistJs/chartistJs.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule
  ],
  declarations: [
    ChartistJs
  ],
  providers: [
    ChartistJsService
  ],
  entryComponents: [
    ChartistJs
  ]
})
export class ChartsModule {}
