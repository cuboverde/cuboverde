import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserInterface } from '../interfaces/interfaces' 

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private apiUrl = `${environment.apiurl}/users`;
  constructor(private httpClient: HttpClient) { }
  getUsuarios(): Observable<UserInterface[]> {
    return this.httpClient.get<UserInterface[]>(this.apiUrl);
  }

}

