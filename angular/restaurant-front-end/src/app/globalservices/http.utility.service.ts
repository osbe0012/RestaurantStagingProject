import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpUtilityService {

  constructor() { }

  public  buildDefaultJsonConfig(useCredentials:boolean = false){
    let headers:HttpHeaders = new HttpHeaders();
    let options:Object = {
        headers: headers,
        observe:'response',
        responseType:'json',
        withCredentials: useCredentials
    }
    headers.append("content-type","application/json");
    headers.append("accepts","application/json");
    
    return options;
  }




}
