import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../order.model';
import { OrderService } from '../services/orderService';

@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})
export class OrderCreateComponent implements OnInit {
  orderModel:OrderModel = new OrderModel();



  submitOrder(){

    //this.orderService.submitOrder(this.orderModel).subscribe(() => {
console.log(this.orderModel);
//});

   
  }
 // constructor(private orderService:OrderService,) { }
  ngOnInit(): void {
  }

}
