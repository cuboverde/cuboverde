import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PublicationInterface } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root'
})
export class PublicationsService {

  private apiUrl = `${environment.apiurl}/publications`;
  constructor(private httpClient: HttpClient) { }
  getPublications(): Observable<PublicationInterface[]> {
    return this.httpClient.get<PublicationInterface[]>(this.apiUrl);
  }

  postPublications(article:any): Observable<PublicationInterface[]> {
    return this.httpClient.post<PublicationInterface[]>(this.apiUrl,article);
  }

  aprovedPublications(id:any): Observable<PublicationInterface[]> {
    return this.httpClient.post<PublicationInterface[]>(`${this.apiUrl}/aprove/${id}`,id);
  }


}
