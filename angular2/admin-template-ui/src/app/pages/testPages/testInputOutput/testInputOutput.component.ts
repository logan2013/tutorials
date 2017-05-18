import {Component, OnInit} from '@angular/core';
@Component({
    selector: 'test-input-output',
    template: `
            <input-output-child [memberId2]="memberId" (childBtnClick)="onChildBtnClick($event)"></input-output-child> 
    `
})
export class TestInputOutputComponent implements OnInit {

    memberId: number;

    ngOnInit(): void {
        // 赋值
        this.memberId = 196;
    }

    onChildBtnClick(memberId:number) {
        alert(memberId);
    }
}