import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderDispatchComponent } from './order-dispatch/order-dispatch.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';

const routes: Routes = [
  {path: '', redirectTo: 'order-list', pathMatch: 'full'},
  {path: 'dispatch-order', component: OrderDispatchComponent},
  {path: 'order-list', component: ViewOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
