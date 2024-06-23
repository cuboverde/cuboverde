import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  constructor(private route : ActivatedRoute ) {}

  private readonly endpoint = `${environment.apiurl}/publications/${this.route.snapshot.params['id']}`;
  httpClient = inject(HttpClient);
  article:any = {};

  
  ngOnInit(): void {
    console.log('entro ');
    this.fetchData();
  }
  fetchData() {
    this.httpClient.get(this.endpoint)
      .subscribe((article) => {
        console.log(this.article);
        this.article = article;
      });
  }  
}
