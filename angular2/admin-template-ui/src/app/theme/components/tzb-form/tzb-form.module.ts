import {
  TextInputComponent,
  PasswordInputComponent,
  TextareaComponent,
  SelectInputComponent,
  DatepickerInputComponent,
  BlueBtnComponent,
  RedBtnComponent,
  GreyBtnComponent,
  CheckboxComponent,
  FormLabelComponent,
  RadiosComponent
} from "./components";

import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  imports: [NgbModule, BrowserModule],
  declarations: [
    TextInputComponent,
    PasswordInputComponent,
    TextareaComponent,
    SelectInputComponent,
    DatepickerInputComponent,
    BlueBtnComponent,
    RedBtnComponent,
    GreyBtnComponent,
    CheckboxComponent,
    FormLabelComponent,
    RadiosComponent
  ],
  exports: [
    TextInputComponent,
    PasswordInputComponent,
    TextareaComponent,
    SelectInputComponent,
    DatepickerInputComponent,
    BlueBtnComponent,
    RedBtnComponent,
    GreyBtnComponent,
    CheckboxComponent,
    FormLabelComponent,
    RadiosComponent
  ]
})
export class TzbaoFormModule {

}
