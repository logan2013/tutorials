import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AppChildComponent } from './app-child/app-child.component';
import { AppChild2Component } from './app-child2/app-child2.component';
import { AppChild3Component } from './app-child3/app-child3.component';
import { AppChild4Component } from './app-child4/app-child4.component';

@NgModule({
  declarations: [
    AppComponent,
    AppChildComponent,
    AppChild2Component,
    AppChild3Component,
    AppChild4Component
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
