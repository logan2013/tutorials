import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CKEditorModule } from 'ng2-ckeditor';
import { NgaModule } from '../../theme/nga.module';
import { Ckeditor } from './components/ckeditor/ckeditor.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    CKEditorModule
  ],
  declarations: [
    Ckeditor
  ],
  entryComponents: [
    Ckeditor
  ]
})
export class EditorsModule {
}
