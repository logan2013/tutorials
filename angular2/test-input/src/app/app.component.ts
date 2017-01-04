import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <h1>Hello {{message}}</h1>
  <appchild [greetMessage]="childmessage"></appchild>
  <appchild2 [greetMessage]="childmessage2"></appchild2>
  <appchild3 *ngFor="let item of childNameArray" [Name]="item"></appchild3>
  
  <br/>
  <button (click)="nextCount()">change count</button>
  
  <br/>
  
  <appchild4 [counter]="count"></appchild4>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message: string = "I am Parent";
  childmessage: string = "I am passed from Parent to child component";
  childmessage2: string = "I am passed from Parent to child component";
  childNameArray = ['foo', 'koo', ' ', 'moo', 'too', 'hoo', ''];

  count: number = 0;

  nextCount() {
    console.log("hahahah");

    this.count = this.getRandomIntInclusive(this.count, this.count + 1000);
  }

  getRandomIntInclusive(min: number, max: number) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
}
