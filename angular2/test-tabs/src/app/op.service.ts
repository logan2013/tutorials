import {Injectable}           from '@angular/core';
import {HeroJobOpComponent}   from './hero-job-op.component';
import {HeroProfileOpComponent} from './hero-profile-op.component';
import {OpItem}               from './op-item';
@Injectable()
export class OpService {
  getAds() {
    return [
      new OpItem(HeroProfileOpComponent.TITLE, HeroProfileOpComponent, {
        name: 'Bombasto',
        bio: 'Brave as they come'}),
      new OpItem(HeroJobOpComponent.TITLE, HeroProfileOpComponent, {
        headline: 'Hiring for several positions',
        body: 'Submit your resume today!'
      })
    ];
  }
}
