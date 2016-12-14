import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<div class="container">
  <input [value]="name" (input)="name=$event.target.value"/>
  <br/>
  <h1>Hello {{name}}</h1>
</div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name:string = '';
}
