import {NgModule} from '@angular/core';
import {Module0510} from './test0510/0510.module';
import {TestForModule} from './testFor/testFor.module';
import {TestInputOutputModule} from './testInputOutput/testInputOutput.module';
import {TestViewChildModule} from './testViewChild/testViewChild.module';
import {TestInjectParentModule} from './testInjectParent/testInjectParent.module';
import {ModuleZzh} from "./testZzh/zzh.module";
import {TestAnyCompInteractModule} from './testAnyCompInteract/testAnyCompInteract.module';
import {TestHttpModule} from './testHttp/testHttp.module';
import {TestFormModule} from './testForm/testForm.module';

@NgModule({
    imports: [
        Module0510,
        TestForModule,
        TestInputOutputModule,
        TestViewChildModule,
        TestInjectParentModule,
        ModuleZzh,
        TestAnyCompInteractModule,
        TestHttpModule,
        TestFormModule
    ]
})
export class TestPagesModule {
}
