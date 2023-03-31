import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';



@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit{

  orders: Order[];

  constructor(private orderService: OrderService) {

  }

  ngOnInit() {

    this.orderService.findAll().subscribe(data => {
      this.orders = data;
    });
  }

}
