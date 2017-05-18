import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TestInputOutputComponent} from './testInputOutput.component';
import {ChildComponent} from './child.component';
import {TestViewChildComponent} from './testViewChild.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        TestViewChildComponent,
        ChildComponent
    ],
    entryComponents: [
        TestViewChildComponent
    ]
})
export class TestViewChildModule {
}
