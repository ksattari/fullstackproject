import { Component,Inject,
   LOCALE_ID, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';
import {formatCurrency} from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { OrderDialogComponent } from '../order-dialog/order-dialog.component';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';




@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit{

  orders: Order[];
  dialogRef: any;
  order: Order;
  mySubscription;

  constructor(private orderService: OrderService,private router: Router,
     private activatedRoute: ActivatedRoute,@Inject(LOCALE_ID) public locale: string,
     public dialog: MatDialog) {

      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.mySubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
         // Trick the Router into believing it's last link wasn't previously loaded
         this.router.navigated = false;
      }
    }); 

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

  deleteOrder(id: string){
    this.orderService.delete(id); 
    this.orders = this.orders.filter(e => e.orderId != id );
  }

  ngOnDestroy(){
    if (this.mySubscription) {
      this.mySubscription.unsubscribe();
    }
  }

 
}


