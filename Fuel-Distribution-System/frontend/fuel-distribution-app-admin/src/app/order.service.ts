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

checkOrderById(id: string): Observable<OrderModel[]> {
  return this.httpClient.get<OrderModel[]>(`${this.searchURL}/${id}`);
}

orderComplete(id: string, reserved: string) {
  return this.httpClient.put(`${this.searchURL}/${id}/${status}`, "");
}





}
