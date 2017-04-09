import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {TabComponent} from "./tab.component";
import {Act1Component} from "./act1.component";
import {TabContentDirective} from "./tab-content.directive";
import {TabsetComponent} from "./tabset.component";

@NgModule({
  declarations: [
    AppComponent,
    TabComponent,
    Act1Component,
    TabContentDirective,
    TabsetComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [Act1Component]
})
export class AppModule { }
