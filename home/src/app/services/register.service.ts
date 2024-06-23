import { EventEmitter, Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpParams, HttpClientModule } from '@angular/common/http';
import { map, tap, Observable } from 'rxjs';
import { UserInterface } from '../interfaces/interfaces' 

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  endPoint: string = environment.apiurl+'/users'
  constructor(private http: HttpClient) { }
  
  public userRegister(user:any):Observable<UserInterface>{

    const params = new HttpParams()
      .set('email', user.email)
      .set('fistName', user.fistName)
      .set('lastName', user.lastName)
      .set('phone', user.phone)
      .set('userPassword',user.userPassword)
      .set('creationDate',user.creationDate)
      .set('idRol',3)

    return this.http.post<UserInterface>(this.endPoint,user);

  }
}
