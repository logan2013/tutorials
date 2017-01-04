import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'appchild2',
  template: `
    <h2>
      Hi {{_greetMessage}}
    </h2>
  `,
  styles: []
})
export class AppChild2Component implements OnInit {

  _greetMessage: string;

  @Input() set greetMessage(message: string) {
    this._greetMessage = message + " manipulated at child component";
  }

  constructor() { }

  ngOnInit() {
  }

}
