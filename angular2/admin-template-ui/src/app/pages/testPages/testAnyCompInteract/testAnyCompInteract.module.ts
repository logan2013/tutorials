import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TestInputOutputComponent} from './testInputOutput.component';
import {ChildComponent} from './child.component';
import {TestAnyCompInteractComponent} from './testAnyCompInteract.component';
import {Child2Component} from './child2.component';
import {SharedService} from './shared.service';
import {HttpModule} from '@angular/http';

@NgModule({
    imports: [
        CommonModule,
        HttpModule
    ],
    declarations: [
        TestAnyCompInteractComponent,
        ChildComponent,
        Child2Component
    ],
    entryComponents: [
        TestAnyCompInteractComponent
    ],
    providers: [
        SharedService
    ]
})
export class TestAnyCompInteractModule {
}
