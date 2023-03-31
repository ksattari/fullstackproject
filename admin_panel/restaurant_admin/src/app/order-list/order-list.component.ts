import { Component,Inject,
   LOCALE_ID, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';
import {formatCurrency} from '@angular/common';



@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit{

  orders: Order[];

  constructor(private orderService: OrderService,@Inject(LOCALE_ID) public locale: string) {

  }

  ngOnInit() {

    this.orderService.findAll().subscribe(data => {
      this.orders = data;
    });
  }

  formatStringCurrency(snum: string): string{

    const num = parseFloat(snum);
    return  formatCurrency(num,this.locale,'$');

  }

}
