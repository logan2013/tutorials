/**
 * Created by Administrator on 2017/4/24.
 */
import './ckeditor.loader';
import 'ckeditor';
import 'style-loader!./ckeditor.scss';

import {Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'test2',
  styleUrls: ['./test2.scss'],
  templateUrl: './test2.html',
})

export class Test2 {

  testForm: FormGroup;

  constructor(fb: FormBuilder) {
    this.testForm = fb.group({
      textInput1: [{value: '', disabled: false}, [Validators.required, Validators.minLength(3)]],
      ckeditorContent: '<p>Hello abdfdfdfdf</p>'
    });
  }
  isTestInput1Invalid(key: string) {
    const textInput1Ctronl = this.testForm.get(key);
    return (textInput1Ctronl.touched || textInput1Ctronl.dirty) && textInput1Ctronl.errors;
  }

  public config = {
    uiColor: '#F0F3F4',
    height: '600',
  };


}
