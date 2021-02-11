import { Component, OnInit } from '@angular/core';
import {faUser} from '@fortawesome/free-regular-svg-icons'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public userIcon:any;

  constructor() { 
    this.userIcon = faUser;
  }

  ngOnInit(): void {
  }

}
