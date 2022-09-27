import { Component, OnInit } from '@angular/core';
import { Dispatch } from '../dispatch.model';
import { DispatchService } from '../dispatch.service';


@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {

  constructor(private dispatchService: DispatchService) { }
  dispatches!: Dispatch[];

  ngOnInit(): void {
    this.getAllOrders();
  }

  private getAllOrders() {
    this.dispatchService.getAllOrders().subscribe(data => {
      this.dispatches = data;
      console.log(data);
    })
  }

}
