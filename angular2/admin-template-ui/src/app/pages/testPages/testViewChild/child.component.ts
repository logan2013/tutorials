import {OnInit, Component, Input, EventEmitter, Output} from '@angular/core';
@Component({
    selector: 'view-child',
    template: `
            
       <p>view child</p>
        
    `
})
export class ChildComponent implements OnInit {

    selectedMemberName: string = 'sz088';

    ngOnInit(): void {
    }


}