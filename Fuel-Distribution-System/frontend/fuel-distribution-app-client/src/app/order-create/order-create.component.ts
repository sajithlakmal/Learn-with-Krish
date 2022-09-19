import { VariableBinding } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../order.model';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})

export class OrderCreateComponent implements OnInit {

  sucess!: boolean;

  jsonString!:any;
  orderModel: OrderModel = new OrderModel();

  constructor(private orderService: OrderService) { }
  submitOrder() {

    this.orderService.submitOrder(this.orderModel).subscribe(data => {
      data.toLocaleString;

     console.log(data)
      this.sucess = true;

    },
    
      error => console.log(error))
  }
  ngOnInit(): void {
  }

}
