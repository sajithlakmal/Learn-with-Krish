import { Component } from "@angular/core";

@Component({
    selector: 'order',
    template: `
    <h2></h2>
    <ul>
    {{f()}}
    <li *ngFor="let octanins of octanin">
        {{ octanins}}
    </li>
    </ul>     
    `
})

 
export class OrderComponent{

 title = 'List of Octanin';
 octanin =[92,95,98]

 f(){
    console.log(this.title);
 }

}