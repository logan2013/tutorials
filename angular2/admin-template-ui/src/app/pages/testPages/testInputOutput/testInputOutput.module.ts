import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TestInputOutputComponent} from './testInputOutput.component';
import {ChildComponent} from './child.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        TestInputOutputComponent,
        ChildComponent
    ],
    entryComponents: [
        TestInputOutputComponent
    ]
})
export class TestInputOutputModule {
}
