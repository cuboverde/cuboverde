import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BlogInterface, RolesInterface } from '../interfaces/interfaces';
import { Observable, catchError, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RolesService {

  private apiUrl = `${environment.apiurl}/roles`;
  constructor(private httpClient: HttpClient) { }
  getRoles(): Observable<RolesInterface[]> {
    return this.httpClient.get<RolesInterface[]>(this.apiUrl);

  }}
