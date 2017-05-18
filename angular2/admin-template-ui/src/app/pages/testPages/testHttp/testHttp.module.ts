import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpModule} from '@angular/http';
import {TestHttpComponent} from './testHttp.component';
@NgModule({
    imports: [
        CommonModule,
        HttpModule
    ],
    declarations: [
        TestHttpComponent
    ],
    entryComponents: [
        TestHttpComponent
    ],
    providers: [

    ]
})
export class TestHttpModule {
}