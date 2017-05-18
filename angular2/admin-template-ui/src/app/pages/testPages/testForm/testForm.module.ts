import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {TestFormComponent} from './testForm.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
@NgModule({
    imports: [
        ReactiveFormsModule,
        BrowserModule,
        HttpModule
    ],
    declarations: [
        TestFormComponent
    ],
    entryComponents: [
        TestFormComponent
    ],
    providers: [

    ]
})
export class TestFormModule {
}