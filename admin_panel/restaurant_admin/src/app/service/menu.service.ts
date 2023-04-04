import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MenuItem} from '../model/menu-item';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private  url = 'http://localhost:8085';
  private ordersUrl: string;
  private deleteUrl: string;

  constructor(private http: HttpClient) {
    this.ordersUrl = this.url + '/menu';
    this.deleteUrl = this.url + '/items/';
   }

   public findAll(): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(this.ordersUrl);
  }

  public save(menuItem: MenuItem) {
    return this.http.post<MenuItem>(this.ordersUrl, menuItem);
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