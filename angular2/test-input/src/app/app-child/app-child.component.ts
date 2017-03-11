import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'appchild',
  template: `
    <h2>
      Hi {{greetMessage}}
    </h2>
  `,
  styles: []
})
export class AppChildComponent implements OnInit {

  @Input() greetMessage: string = "I am Child";

  constructor() { }

  ngOnInit() {
  }

}
