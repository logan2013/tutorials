import {Component, OnInit, ViewChild} from '@angular/core';
import {PaginationComponent} from '../../../../theme/pagination/pagination.component';

@Component({
    selector: 'prime-ng-data-table',
    template: `
        
        <button class="button btn btn-primary" (click)="query()">查询</button>

        <p-dataTable [value]="cars">
            <p-column field="vin" header="Vin"></p-column>
            <p-column field="year" header="Year"></p-column>
            <p-column field="date" header="Brand">
                <ng-template let-col let-car="rowData" let-ri="rowIndex" pTemplate="body">
                {{car[col.field] | date:'y-MM-dd HH:mm:ss'}}
                </ng-template>
            </p-column>
            <p-column field="color" header="Color"></p-column>
            
            <p-column>
                <ng-template pTemplate="header">
                    操作
                </ng-template>
                <ng-template let-car="rowData" pTemplate="body">
                    <button type="button" icon="fa-search" class="btn btn-primary">详情</button>
                    <button type="button" icon="fa-search" class="btn btn-warning ml-lg-2 ml-md-2 ">审核</button>
                </ng-template>
            </p-column>
            
        </p-dataTable>
        
        <pagination class="pagination-sm"
            [itemsPerPage]="itemsPerPage"
            [maxSize]="maxSize"
            [boundaryLinks]="true"
            [rotate]="false"
            (pageChanged)="onChangePage($event)"></pagination>
    `
})
export class PrimeNgDataTableComponent implements OnInit {

    @ViewChild(PaginationComponent) paginationComponent: PaginationComponent;

    cars: Car[];

    itemsPerPage: number = 5;
    maxSize: number = 3;

    constructor() {
    }

    ngOnInit(): void {
    }

    query() {
        this.paginationComponent.totalItems = 7;
        this.paginationComponent.selectPage(1);
        this.onChangePage({page: 1});
    }

    public onChangePage(pageInfo: any): void {

        if (pageInfo.page === 1) {
            this.cars = [];

            this.cars.push({
                vin: '张三',
                year: '2015',
                date: new Date(),
                color: 'red'
            });

            this.cars.push({
                vin: '李四',
                year: '2015',
                date: new Date(),
                color: 'red'
            });

            this.cars.push({
                vin: '王五',
                year: '2015',
                date: new Date(),
                color: 'red'
            });


            this.cars.push({
                vin: '马六',
                year: '2015',
                date: new Date(),
                color: 'red'
            });

            this.cars.push({
                vin: '神七',
                year: '2015',
                date: new Date(),
                color: 'red'
            });
        } else {
            this.cars = [];

            this.cars.push({
                vin: '王八',
                year: '2015',
                date: new Date(),
                color: 'red'
            });

            this.cars.push({
                vin: '赵九',
                year: '2015',
                date: new Date(),
                color: 'red'
            });
        }
    }
}

interface Car {
    vin: string;
    year: string;
    date: any;
    color: string;
}
