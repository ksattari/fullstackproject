import { Component,Inject,
   LOCALE_ID, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';
import {formatCurrency} from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { OrderDialogComponent } from '../order-dialog/order-dialog.component';




@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit{

  orders: Order[];
  dialogRef: any;
  order: Order;

  constructor(private orderService: OrderService,
    @Inject(LOCALE_ID) public locale: string,public dialog: MatDialog) {

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

  openOrderItemDialog(orderId: string) {

    this.order = this.orders.find(e => e.orderId === orderId) as Order;
    this.dialogRef = this.dialog.open(OrderDialogComponent,
      { data: this.order, height: '500px', width: '400px' });
  
  } 

}
