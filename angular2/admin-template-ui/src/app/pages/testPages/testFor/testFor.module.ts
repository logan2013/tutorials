import {NgModule} from '@angular/core';
import {Module0510} from './test0510/0510.module';
import {CommonModule} from '@angular/common';
import {TestForComponent} from './testForm.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        TestForComponent
    ],
    entryComponents: [
        TestForComponent
    ]
})
export class TestForModule {
}
