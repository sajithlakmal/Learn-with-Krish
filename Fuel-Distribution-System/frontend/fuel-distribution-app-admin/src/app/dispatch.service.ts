import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dispatch } from './dispatch.model';

@Injectable({
  providedIn: 'root'
})

export class DispatchService {

  private url = "http://localhost:8082/dispatch";
  private searchURL = "http://localhost:8082/orders/";


  constructor(private httpClient: HttpClient) { }

  dispatch(orderId : string) : Observable<Dispatch> {
    return this.httpClient.post<Dispatch>(this.url, {orderId});
  }


  getAllOrders(): Observable<Dispatch[]> {
    return this.httpClient.get<Dispatch[]>(`${this.searchURL}`);
  }

}