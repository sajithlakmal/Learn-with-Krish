import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../order.model';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-search',
  templateUrl: './order-search.component.html',
  styleUrls: ['./order-search.component.css']
})
export class OrderSearchComponent implements OnInit {

  constructor(private orderService: OrderService) { }

  orderId!: string;
  scheduled!: boolean;
  orders!: OrderModel[];
  orderDetails: any;


  ngOnInit(): void {
  }
  checkOrderById() {
    console.log(this.orderId);
    this.orderService.checkOrderById(this.orderId).subscribe(data => {
      this.orderDetails = data;
      console.log(data);
    },
      error => console.log(error));
  }
}
