import {Component, Input}  from '@angular/core';
import {OpComponent}       from './op.component';
@Component({
  template: `
    <div class="hero-profile">
      <h3>Featured Hero Profile</h3>
      <h4>{{data.name}}</h4>
      <p>{{data.bio}}</p>
      <strong>Hire this hero today!</strong>
    </div>
  `
})
export class HeroProfileOpComponent implements OpComponent {

  @Input() data: any;

  static TITLE: string = "功能11";
}
