import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ThanksComponent} from "./thanks.component";
import {GreeterComponent} from "./greeter.component";

const routes: Routes = [
  {
    path: '',
    children: []
  },
  {path: "greet", component: GreeterComponent},
  {path: "thanks", component: ThanksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
