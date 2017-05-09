// todo: split
import {Injectable} from '@angular/core';

/** Provides default values for Pagination and pager components */
@Injectable()
export class PaginationConfig {
    public main: any = {
        maxSize: void 5,
        itemsPerPage: 10,
        boundaryLinks: true,
        directionLinks: true,
        firstText: '首页',
        previousText: '上一页',
        nextText: '下一页',
        lastText: '末页',
        pageBtnClass: '',
        rotate: true
    };
    public pager: any = {
        itemsPerPage: 15,
        previousText: '« Previous',
        nextText: 'Next »',
        pageBtnClass: '',
        align: true
    };
}