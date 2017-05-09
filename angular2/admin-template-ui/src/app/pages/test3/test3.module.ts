import {NgModule} from "@angular/core";
import {Test3} from "./test3.component";
import { NgaModule } from '../../theme/nga.module';
import { TzbaoFormModule } from '../../theme/components/tzb-form/tzb-form.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {TzbaoLayoutModule} from "../../theme/components/tzb-layout/tzb-layout.module";
import { PaginationModule } from '../../theme/pagination/pagination.module';
import { Ng2TableModule } from "ng2-table/ng2-table";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@NgModule({
  imports: [
    NgaModule,
    NgbModule,
    TzbaoFormModule,
    TzbaoLayoutModule,
    Ng2TableModule,FormsModule,
    PaginationModule.forRoot(),
   CommonModule],
  declarations: [
    Test3
  ],
  entryComponents: [
    Test3
  ]
})
export class TestModule3 {

}
