import {NgModule} from "@angular/core";
import {Test} from "./test.component";
import { NgaModule } from '../../theme/nga.module';
import { TzbaoFormModule } from '../../theme/components/tzb-form/tzb-form.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {TzbaoLayoutModule} from "../../theme/components/tzb-layout/tzb-layout.module";
import { PaginationModule } from '../../theme/pagination/pagination.module';
import { Ng2TableModule } from "ng2-table/ng2-table";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CalendarModule } from '../../theme/plugin/primeNG/calendar/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  imports: [
    NgaModule, NgbModule, TzbaoFormModule,TzbaoLayoutModule,CommonModule,Ng2TableModule,FormsModule,
    PaginationModule.forRoot(),CalendarModule,
    BrowserAnimationsModule
  ],
  declarations: [
    Test
  ],
  entryComponents: [
    Test
  ]
})
export class TestModule {

}
