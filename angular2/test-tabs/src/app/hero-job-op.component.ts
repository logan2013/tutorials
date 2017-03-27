import {Component, Input} from '@angular/core';
import {OpComponent}  from './op.component';
@Component({
  template: `
    <div class="job-ad">
      <h4>{{data.headline}}</h4> 
      {{data.body}}
    </div>
  `
})
export class HeroJobOpComponent implements OpComponent {

  @Input() data: any;

  static getTitle(): string {
    return "功能2";
  }
}
