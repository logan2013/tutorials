import {OnInit, Component, Input, EventEmitter, Output} from '@angular/core';
import {TestInjectParentComponent} from './testInjectParent.component';
import {Http} from '@angular/http';
@Component({
    selector: 'test-http',
    template: `
        <button (click)="submitQuery()">查询</button>
    `
})
export class TestHttpComponent implements OnInit {

    constructor(private http: Http) {
    }

    ngOnInit(): void {
    }

    submitQuery() {
        this.http.post('/getMember', {memberId: 196}).subscribe(response => {
            const data = response.json();
        });
    }
}