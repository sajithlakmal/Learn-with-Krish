import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderCreateComponent } from './order-create/order-create.component';
import { OrderSearchComponent } from './order-search/order-search.component';

const routes: Routes = [
  {path: '', redirectTo: 'createorder', pathMatch: 'full'},
  {path: 'createorder', component: OrderCreateComponent},
  {path: 'ordersearch', component: OrderSearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
