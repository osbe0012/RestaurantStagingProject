import { Component } from '@angular/core';
interface Custom extends Object{
  methodOne:()=>number;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
//ignore AppComponentSquigs
export class AppComponent {
  title = 'restaurant-front-end';


}
