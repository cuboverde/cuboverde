import { HttpClient, HttpParams } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  redirectUrl: string="";
  endPoint: string =`${environment.apiurl}/login`
  
  getLoggelnName = new EventEmitter<boolean>();

  constructor(private http: HttpClient) { }

  /* endPoint:string = `${environment.apiurl}/publications`
  constructor(private httpClient: HttpClient) { }

  getBlogList(): Observable <BlogInterface[]> {
    return this.httpClient.get<BlogInterface[]>(this.endPoint);
  } */
  
  
  public userlogin(user:any):Observable<any>{
    // console.log(user)
    const params = new HttpParams()
      .set('email', user.email)
      .set('password',user.password)

    return this.http.post<any>(`${this.endPoint}?${params.toString()}`,user)
    .pipe(
      tap(response =>{
        console.log("Http response",response);
      }),
      map(user=>{
        this.setToken(user.name);
        this.getLoggelnName.emit(true);
        return user;
      })
    );
    console.log(user)
  }

  setToken(token:string){
    localStorage.setItem('token',token);
  }

  getToken(){
    return localStorage.getItem('token');
  }

  deleteToken(){
    localStorage.removeItem('token');
  }

  isLoggedIn(){
    const usertoken = this.getToken();
    if(usertoken != null){
      return true;
    }
    return false;
  }

}