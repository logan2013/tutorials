import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {AdBannerComponent} from "./ad-banner.component";
import {HeroProfileComponent} from "./hero-profile.component";
import {HeroJobAdComponent} from "./hero-job-ad.component";
import {AdService} from "./add.service";
import {AdDirective} from "./ad.directive";
import {TabComponent} from "./tab.component";
import {TabsComponent} from "./tabs.component";
@NgModule({
  declarations: [
    AppComponent,
    AdBannerComponent,
    HeroJobAdComponent,
    HeroProfileComponent,
    AdDirective,
    TabComponent,
    TabsComponent
  ],
  entryComponents: [HeroJobAdComponent, HeroProfileComponent],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [AdService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
