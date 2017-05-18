import {Component, OnInit, ViewChild} from '@angular/core';
import {ChildComponent} from './child.component';

@Component({
    selector: 'test-input-output',
    template: `
           <view-child></view-child>
    `
})
export class TestViewChildComponent implements OnInit {

    @ViewChild(ChildComponent) viewChildComponent: ChildComponent;

    ngOnInit(): void {

        alert(this.viewChildComponent.selectedMemberName);
    }

}