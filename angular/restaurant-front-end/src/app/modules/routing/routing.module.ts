import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import { LoginComponent } from '../not.authenticated/login/login.component';
import { AppComponent } from 'src/app/app.component';



const appRoutes:Routes = [
  {path:"login", component:LoginComponent, pathMatch: "full"},
  {path:"**", component:AppComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ], 
  exports:[RouterModule]
}
)
export class RoutingModule { }
