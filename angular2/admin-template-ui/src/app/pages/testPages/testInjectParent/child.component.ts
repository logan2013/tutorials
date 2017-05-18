import {OnInit, Component, Input, EventEmitter, Output} from '@angular/core';
import {TestInjectParentComponent} from './testInjectParent.component';
@Component({
    selector: 'inject-parent',
    template: `
            
       <p>inject child</p>
        
    `
})
export class ChildComponent implements OnInit {

    constructor(private parentComp: TestInjectParentComponent) {
    }


    ngOnInit(): void {
        alert(this.parentComp.memberName);
    }


}