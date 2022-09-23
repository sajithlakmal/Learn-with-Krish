import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderModel } from './order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private url = "http://localhost:8082/order";
  private searchURL = "http://localhost:8082/orders";

  constructor(private httpClient: HttpClient) { }

  submitOrder(order: OrderModel): Observable<Object> {

    neworder: OrderModel;
    console.log(order);
    return this.httpClient.post(`${this.url}`,order);
  
  }
  checkOrderById(id: string): Observable<OrderModel[]> {
    return this.httpClient.get<OrderModel[]>(`${this.searchURL}/${id}`);
  }

}
