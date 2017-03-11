import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'appchild3',
  template: `
    <h2>
      {{_name}}
    </h2>
  `,
  styles: []
})
export class AppChild3Component implements OnInit {

  _name: string;

  @Input() set Name(name: string) {
    this._name = (name && name.trim()) || "I am default name";
  }

  constructor() { }

  ngOnInit() {
  }

}
