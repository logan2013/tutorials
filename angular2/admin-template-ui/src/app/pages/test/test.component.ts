/**
 * Created by Administrator on 2017/4/24.
 */
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { PaginationComponent } from '../../theme/pagination/pagination.component';
import { TableData } from './table-data';

@Component({
  selector: 'test',
  styleUrls: ['./test.scss'],
  templateUrl: './test.html',
  encapsulation: ViewEncapsulation.None
})

export class Test implements OnInit {

  /**
   * 配置
   * @type {{paging: boolean; className: [string,string]}}
   */
  public config: any = {
    paging: true, // 是否需要分页
    className: ['table-striped', 'table-bordered'] // table的class
  };

  /**
   * 每页数据明细
   * @type {Array}
   */
  public rows: Array<any> = [];

  /**
   * 列配置
   * @type {[{title: string; name: string; sort: boolean},{title: string; name: string; sort: boolean},{title: string; className: [string,string]; name: string; sort: boolean},{title: string; name: string; sort: boolean},{title: string; className: string; name: string; sort: boolean},{title: string; name: string; sort: boolean}]}
   */
  public columns: Array<any> = [
    {title: 'Name', name: 'name', sort: false},
    {title: 'Position', name: 'position', sort: false},
    {title: 'Office', className: ['office-header', 'text-success'], name: 'office', sort: false},
    {title: 'Extn.', name: 'ext', sort: false},
    {title: 'Start date', className: 'text-warning', name: 'startDate', sort: false},
    {title: 'Salary ($)', name: 'salary', sort: true}
  ];


  /**
   * 分页信息
   *
   */

  public page: number = 1; // 当前页
  public itemsPerPage: number = 20; // 每页记录数
  public maxSize: number = 5;// 显示几页
  public numPages: number = 10;
  public length: number = 0; // 总记录数

  /**
   * 总的数据明细
   * @type {Array<any>}
   */
  private data: Array<any> = TableData;

  @ViewChild(PaginationComponent) paginationComponent: PaginationComponent;

  public constructor() {
    this.length = this.data.length;
  }

  public ngOnInit(): void {
    // 加载显示第一页
    this.onChangeTable(this.config);
  }

  /**
   * 点击分页
   * @param page
   * @param data
   * @returns {any[]}
   */
  public changePage(page: any, data: Array<any> = this.data): Array<any> {
    let start = (page.page - 1) * page.itemsPerPage;
    let end = page.itemsPerPage > -1 ? (start + page.itemsPerPage) : data.length;
    return data.slice(start, end);
  }

  public onChangeTable(config: any, page: any = {page: this.page, itemsPerPage: this.itemsPerPage}): any {
    this.rows = page && config.paging ? this.changePage(page, this.data) : this.data;
    this.length = this.data.length;
  }

  public onCellClick(data: any): any {
    console.log(data);
  }

  changePagination() {
    this.paginationComponent.totalItems = 200;
  }
}
