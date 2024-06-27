import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { TagsComponent } from '../tags/tags.component';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [TagsComponent],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  constructor(private route : ActivatedRoute ) {}

  private readonly endPoint = `${environment.apiurl}/publications/`;
  httpClient = inject(HttpClient);
  article:any = {};
  id:any= this.route.snapshot.params['id'];

  ngOnInit(): void {
    this.fetchLike()
    this.fetchData();
  }

  fetchData() {
    this.httpClient.get(this.endPoint+this.route.snapshot.params['id'])
      .subscribe((article) => {
        this.article = article;
      });
  }

  fetchLike() {
    this.httpClient.put(`${this.endPoint}likes/${this.route.snapshot.params['id']}`,this.id).subscribe((article) => {
      this.id = this.route.snapshot.params['id'];
    });
  }

;
  meGusta(){

    this.httpClient.put(`${this.endPoint}favorites/${this.route.snapshot.params['id']}`,this.id).subscribe((article) => {
      this.id = this.route.snapshot.params['id'];
    });
  }

  compartir(){
    this.httpClient.put(`${this.endPoint}shared/${this.route.snapshot.params['id']}`,this.id).subscribe((article) => {
      this.id = this.route.snapshot.params['id'];

    });
  }

}
