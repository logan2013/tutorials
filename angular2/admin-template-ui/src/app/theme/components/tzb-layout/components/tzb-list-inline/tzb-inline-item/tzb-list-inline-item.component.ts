/**
 * Created by Administrator on 2017/5/3.
 */
import { Component, Input } from '@angular/core';
@Component({
  selector:"tzb-list-inline-item",
  templateUrl:"./tzb-list-inline-item.html"
})
export class  ListInlineItem{

  @Input() text: string = '文本';
}
