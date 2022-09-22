import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrderSearchComponent } from './order-search.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    OrderSearchComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class OrderSearchModule { }
