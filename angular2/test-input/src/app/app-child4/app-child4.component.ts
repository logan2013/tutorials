import {Component, OnInit, Input, OnChanges, SimpleChange} from '@angular/core';

@Component({
  selector: 'appchild4',
  template: `
    <h2>
      {{counter}}
    </h2>
    
    <h2>Value Changed</h2>
    <ul>
      <li *ngFor="let c of changeLog">{{c}}</li>
    </ul>
  `,
  styles: []
})
export class AppChild4Component implements OnInit, OnChanges {

  @Input() counter: number = 0;
  changeLog: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(changes: {[propKey:string]: SimpleChange}) {
    let log: string[] = [];
    for (let p in changes) {
      let c = changes[p];
      console.log(c);

      let from = JSON.stringify(c.previousValue);
      let to = JSON.stringify(c.currentValue);

      log.push(`${p} changed from ${from} to ${to}`);
    }

    this.changeLog.push(log.join(", "));
  }
}
