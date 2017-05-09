import {NgModule} from "@angular/core";
import {Test2} from "./test2.component";
import { NgaModule } from '../../theme/nga.module';
import { TzbaoFormModule } from '../../theme/components/tzb-form/tzb-form.module';
import { NgbModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import {TzbaoLayoutModule} from "../../theme/components/tzb-layout/tzb-layout.module";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CKEditorModule } from 'ng2-ckeditor';


@NgModule({
  imports: [
    NgaModule, NgbModule, TzbaoFormModule,TzbaoLayoutModule, ReactiveFormsModule, CommonModule,
    CKEditorModule,FormsModule,NgbTypeaheadModule],
  declarations: [
    Test2
  ],
  entryComponents: [
    Test2
  ]
})
export class TestModule2 {

}
