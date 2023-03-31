import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order} from '../model/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private  url = 'http://localhost:8085';
  private ordersUrl: string;
  private deleteUrl: string;

  constructor(private http: HttpClient) {
    this.ordersUrl = this.url + '/orders';
    this.deleteUrl = this.url + '/deleteorder/';
   }

   public findAll(): Observable<Order[]> {
    return this.http.get<Order[]>(this.ordersUrl);
  }

  public save(order: Order) {
    return this.http.post<Order>(this.ordersUrl, order);
  }

  public delete(num: string){
    this.http.delete(this.deleteUrl + num).subscribe({
      next: data => {
          
          console.log("DELETE SUCCESS")
      },
      error: error => {
          console.error('There was an error!', error);
      }
  });

  }
}
