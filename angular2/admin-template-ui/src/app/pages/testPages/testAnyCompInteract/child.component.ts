import {OnInit, Component, Input, EventEmitter, Output} from '@angular/core';
import {SharedService} from './shared.service';
@Component({
    selector: 'any-comp-1',
    template: `
            
       <p>any-comp-1</p>
       
       <button (click)="onClick()">send memberId</button>
      
    `
})
export class ChildComponent implements OnInit {

    constructor(private sharedService: SharedService) {
    }


    ngOnInit(): void {
    }

    onClick() {
        this.sharedService.memberSubject$.next(196);
    }
}