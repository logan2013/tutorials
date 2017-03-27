import {Injectable}           from '@angular/core';
import {HeroJobOpComponent}   from './hero-job-op.component';
import {HeroProfileOpComponent} from './hero-profile-op.component';
import {TabItemData}               from './tab-item-data';
@Injectable()
export class OpService {
  getAds() {
    return [
      new TabItemData(HeroProfileOpComponent.getTitle(), HeroProfileOpComponent, {
        name: 'Bombasto',
        bio: 'Brave as they come'}),
      new TabItemData(HeroJobOpComponent.getTitle(), HeroJobOpComponent, {
        headline: 'Hiring for several positions',
        body: 'Submit your resume today!'
      })
    ];
  }
}
