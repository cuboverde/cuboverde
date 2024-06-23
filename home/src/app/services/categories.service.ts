import { Injectable } from '@angular/core';
import { CategoryInterface } from '../interfaces/interfaces' 
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  private apiUrl = `${environment.apiurl}/categories`;
  constructor(private httpClient: HttpClient) { }
  getCategory(): Observable<CategoryInterface[]> {
    return this.httpClient.get<CategoryInterface[]>(this.apiUrl);
  }
  
}
