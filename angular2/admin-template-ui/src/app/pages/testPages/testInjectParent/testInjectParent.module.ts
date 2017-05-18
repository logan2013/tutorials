import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TestInputOutputComponent} from './testInputOutput.component';
import {ChildComponent} from './child.component';
import {TestViewChildComponent} from './testViewChild.component';
import {TestInjectParentComponent} from './testInjectParent.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        TestInjectParentComponent,
        ChildComponent
    ],
    entryComponents: [
        TestInjectParentComponent
    ]
})
export class TestInjectParentModule {
}
