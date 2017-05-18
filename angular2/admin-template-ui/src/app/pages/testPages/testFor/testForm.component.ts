import {Component, OnInit} from '@angular/core';
@Component({
    selector: 'test-for',
    template: `
            
        <div>
            <button (click)="addPerson()">addPerson</button>
        </div>
    
        <div *ngFor="let data of datas">
            <span>{{data.name}}-{{data.age}}</span>
        </div>
        
    `
})
export class TestForComponent implements OnInit {

    ngOnInit(): void {
        this.datas.push({
            name: 'zhangsan',
            age: 20
        });
    }

    datas: IPerson[] = [];

    addPerson() {
        this.datas.push({
            name: 'lisi',
            age: 30
        });
    }
}

interface IPerson {
    name: string;
    age: number;
}