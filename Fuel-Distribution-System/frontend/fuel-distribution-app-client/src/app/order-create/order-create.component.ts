import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../order.model';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})

export class OrderCreateComponent implements OnInit {

  orderModel: OrderModel = new OrderModel();
  orderDetails: any;

  constructor(private orderService: OrderService) { }
  async submitOrder() {

    console.log(this.orderModel);

    this.orderService.submitOrder(this.orderModel).subscribe(data => {
 
    this.orderDetails = data;
     console.log(data)

    },
    
      error => console.log(error))
  }
  ngOnInit(): void {
  }

}
