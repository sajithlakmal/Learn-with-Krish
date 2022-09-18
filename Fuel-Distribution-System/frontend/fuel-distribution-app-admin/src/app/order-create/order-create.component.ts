import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../order.model';

@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})
export class OrderCreateComponent implements OnInit {
  orderModel:OrderModel = new OrderModel();


  constructor() { }

  submitOrder(){
    console.log(this.orderModel);
  }



  ngOnInit(): void {
  }

}
