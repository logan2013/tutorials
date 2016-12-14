import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <div class="container">
  <input [(ngModel)]="name"/>
  <br/>
  <h1>Hello {{name}}</h1>
</div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
}
