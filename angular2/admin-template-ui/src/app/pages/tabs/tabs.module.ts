import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import {TabComponent} from "./tab.component";
import {TabsetComponent} from "./tabset.component";
import {TabContentDirective} from "./tab-content.directive";

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        TabComponent,
        TabsetComponent,
        TabContentDirective
    ],
    exports: [
        TabComponent,
        TabsetComponent,
        TabContentDirective
    ]
})
export class TabsModule {}