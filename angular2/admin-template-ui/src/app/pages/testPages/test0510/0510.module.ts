/**
 * Created by Administrator on 2017/5/10.
 */
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';


import {Component0510} from './0510.component';
import {ComponentChild0510} from "./0510Child.component";



@NgModule({
    imports:[
        CommonModule,
        FormsModule,
    ],
    declarations:[
        Component0510,
        ComponentChild0510
    ],
    entryComponents:[
        Component0510,
        ComponentChild0510
    ]

})

export class Module0510{}


