import {OnInit, Component, Input, EventEmitter, Output} from '@angular/core';
@Component({
    selector: 'input-output-child',
    template: `
            
       <p>{{memberId2}}</p>
        
       <button (click)="buttonClick($event)">按钮1</button>
    `
})
export class ChildComponent implements OnInit {

    @Input() memberId2: number = -1;

    selectedMemberId: number = 1;

    @Output() childBtnClick: EventEmitter<number> = new EventEmitter<number>();

    ngOnInit(): void {
    }

    buttonClick($event) {
        this.childBtnClick.emit(this.selectedMemberId);
    }
}