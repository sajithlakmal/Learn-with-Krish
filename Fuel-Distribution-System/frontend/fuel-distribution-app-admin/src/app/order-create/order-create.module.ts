import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrderCreateComponent } from './order-create.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    OrderCreateComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class OrderCreateModule { }
