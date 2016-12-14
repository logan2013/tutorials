import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<div class="container">
  <br/>
  
  <countercomponent [(counter)]="c"></countercomponent>
  
  <br/>
  
  <h2>count = {{c}}</h2>
</div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  c: number = 0;
}
