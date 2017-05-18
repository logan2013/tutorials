import {OnInit, Component, Input, EventEmitter, Output, OnDestroy} from '@angular/core';
import {SharedService} from './shared.service';
import {Subscription} from 'rxjs';
@Component({
    selector: 'any-comp-2',
    template: `
            
       <p>any-comp-2</p>
      
    `
})
export class Child2Component implements OnInit, OnDestroy {

    subscription: Subscription;

    constructor(private sharedService: SharedService) {
    }


    ngOnInit(): void {
        /**
         * 订阅主题memberSubject$
         *
         */
        this.subscription = this.sharedService.memberSubject$.subscribe(memberId => {
            console.log("in component 2 " + memberId);
        });
    }

    /**
     * 取消订阅
     */
    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
}