import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './order-list/order-list.component';
import { MenuListComponent } from './menu-list/menu-list.component'

const routes: Routes = [ 
    { path: 'orders', component: OrderListComponent
       
    },
    { path: 'menu-list', component: MenuListComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
