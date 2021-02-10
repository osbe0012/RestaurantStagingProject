import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from 'src/app/models/user';
import { HttpUtilityService } from 'src/app/globalservices/http.utility.service';
@Injectable({
  providedIn: 'root'
})

/**The not authenticated service performs any service related to users that are not authenticated. 
 * For example, using this service, users can attempt to login, register, and etc.
 */
export class NotAuthenticatedService {
 
  
  constructor(private httpClient:HttpClient, private httpUtility: HttpUtilityService) { }

  public login(user:User):Observable<boolean> {
    let returnSubjectAsObservable
    let options: any = this.httpUtility.buildDefaultJsonConfig(true);
    let subjectObservable:Subject<User> = new Subject<User>();
    let httpRequestTemplate:Observable<HttpResponse<User>> = null;

    //1 assign hrt to httpClient.post(...)
    //2 subscribe to hrt and in next, err, complete functions, call appropriate subject function
    //3 return subject as observable
  
    return  null;
    

  }
}
