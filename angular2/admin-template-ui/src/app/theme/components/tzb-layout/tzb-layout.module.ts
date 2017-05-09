/**
 * Created by Administrator on 2017/4/28.
 */


import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { TzbRowComponent } from './components/tzb-row/tzb-row.component';
import { TzbCenterComponent } from './components/tzb-center-block/tzb-center-block.component';
import { TzbTitleComponent } from './components/tzb-title/tzb-title.component';
import { TableNoBorderComponent } from './components/tzb-tables/tzb-table-noborder/tzb-table-noborder.component';
import { TableBorderComponent } from './components/tzb-tables/tzb-table-border/tzb-table-border.component';
import { ListInline } from './components/tzb-list-inline/tzb-list-inline.component';
import { ListInlineItem } from './components/tzb-list-inline/tzb-inline-item/tzb-list-inline-item.component';
import { TzbColComponent } from './components/tzb-col/tzb-col.component';



@NgModule({
  imports: [NgbModule, BrowserModule],
  declarations: [
    TzbRowComponent,TzbCenterComponent,TzbTitleComponent,TableNoBorderComponent, TableBorderComponent,
    ListInline,ListInlineItem,TzbColComponent

  ],
  exports: [
    TzbRowComponent,TzbCenterComponent,TzbTitleComponent,TableNoBorderComponent, TableBorderComponent,
    ListInline,ListInlineItem,TzbColComponent
  ]
})
export class TzbaoLayoutModule {
}
