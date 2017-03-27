import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {HeroProfileOpComponent} from "./hero-profile-op.component";
import {HeroJobOpComponent} from "./hero-job-op.component";
import {OpService} from "./op.service";
import {OpDirective} from "./op.directive";
import {TabComponent} from "./tab.component";
import {TabsComponent} from "./tabs.component";
import {OpButton} from "./op-button";
import {SharedService} from "./shared.service";
@NgModule({
  declarations: [
    AppComponent,
    HeroJobOpComponent,
    HeroProfileOpComponent,
    OpDirective,
    TabComponent,
    TabsComponent,
    OpButton
  ],
  entryComponents: [HeroJobOpComponent, HeroProfileOpComponent],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [OpService, SharedService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
