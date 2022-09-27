import { Component, OnInit } from '@angular/core';
import { Dispatch } from '../dispatch.model';
import { DispatchService } from '../dispatch.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-dispatch',
  templateUrl: './order-dispatch.component.html',
  styleUrls: ['./order-dispatch.component.css']
})
export class OrderDispatchComponent implements OnInit {
  dispatches!: Dispatch[];

  constructor(private dispatchService: DispatchService, private orderService:OrderService) { }

  ngOnInit(): void {
    this.dispatchService.getAllOrders()
  }

  dispatchOrder(id: string) {
    this.orderService.orderComplete(id, "Dispatched").subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }


}
