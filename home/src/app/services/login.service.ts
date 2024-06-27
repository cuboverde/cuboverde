import { HttpClient, HttpParams } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  redirectUrl: string="";
  endPoint: string =`${environment.apiurl}/users/login/`
  getLoggelnName = new EventEmitter<boolean>();

  constructor(private http: HttpClient) { }
  public userlogin(email:any):Observable<any>{
    return this.http.get<any>(`${this.endPoint}${email}`).pipe(
      tap(response =>{

        // console.log("Http response",response);
        return response;
        /* 
        if(response = null){
          response = false;
        }
        */
      }),
      map(user=>{
        let resp = this.getLoggelnName.emit(true);
        return user;
      })
    );
  }

  isLoggedIn(){
    return false;
  }

}