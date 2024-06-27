import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { CategoriesService } from './categories.service';
import { Observable } from 'rxjs';
import { CategoriesInterface } from '../interfaces/interfaces';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TagsService {
  private apiUrl = `${environment.apiurl}/categories`;
  constructor(private httpClient: HttpClient, private categoriesServic: CategoriesService) { }

  getCategories(): Observable <CategoriesInterface[]> {
    return this.httpClient .get<CategoriesInterface[]>(this.apiUrl);
  }

}
