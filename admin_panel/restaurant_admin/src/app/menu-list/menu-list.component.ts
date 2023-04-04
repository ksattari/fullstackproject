import { Component,Inject,
  LOCALE_ID, OnInit } from '@angular/core';
import {MenuService} from '../service/menu.service';
import { MenuItem } from '../model/menu-item';
import {formatCurrency} from '@angular/common';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  menu: MenuItem[];

  constructor(private menuService: MenuService,@Inject(LOCALE_ID) private locale: string){

  }

  ngOnInit() {

    this.menuService.findAll().subscribe(data => {
      this.menu = data;
    });
  }

  formatStringCurrency(snum: string): string{

    const num = parseFloat(snum);
    return  formatCurrency(num,this.locale,'$');

  }

  // openOrderItemDialog(orderId: string) {

  //   this. = this.orders.find(e => e.orderId === orderId) as Order;
  //   this.dialogRef = this.dialog.open(OrderDialogComponent,
  //     { data: this.order, height: '500px', width: '400px' });
  
  // } 

  deleteMenuItem(id: string){
    this.menuService.delete(id); 
    this.menu = this.menu.filter(e => e.itemId != id );
  }

}
