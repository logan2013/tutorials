/**
* the one and only one component of our app
*/

import {Component} from "@angular/core";

@Component({
    selector: "app",
    template: "<h1>Hello {{ name }}!</h1>"
})
export class AppComponent{
    
    name: string;
    
    constructor() {
        this.name = "Angular 2";
    }
}