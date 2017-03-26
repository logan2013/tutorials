import {Component, Input} from '@angular/core';

@Component({
  selector: 'tab',
  styles: [`
    .pane{
      padding: 1em;
    }
  `],
  template: `
    <div [hidden]="!active" class="pane">
      <template ad-host></template>
    </div>
  `
})
export class TabComponent {
  @Input('tabTitle') title: string;
  @Input() active = false;
}
