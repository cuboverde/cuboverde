import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BlogInterface } from '../interfaces/interfaces';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  endPoint:string = `${environment.apiurl}/publications`
  constructor(private httpClient: HttpClient) { }

  getBlogList(): Observable <BlogInterface[]> {
    return this.httpClient.get<BlogInterface[]>(this.endPoint);
  }
}
