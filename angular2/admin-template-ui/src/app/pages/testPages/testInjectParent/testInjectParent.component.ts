import {Component, OnInit, ViewChild} from '@angular/core';
import {ChildComponent} from './child.component';

@Component({
    selector: 'test-input-output',
    template: `
           <inject-parent></inject-parent>
    `
})
export class TestInjectParentComponent implements OnInit {

    memberName: string = 'dajiejie';

    ngOnInit(): void {

    }

}