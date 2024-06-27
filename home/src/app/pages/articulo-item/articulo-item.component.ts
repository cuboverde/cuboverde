import { Component, Input } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { BlogInterface } from '../../interfaces/interfaces';
import { ArticleComponent } from '../article/article.component';

@Component({
  selector: 'app-articulo-item',
  standalone: true,
  imports: [RouterLink, ArticleComponent],
  templateUrl: './articulo-item.component.html',
  styleUrl: './articulo-item.component.css'
})
export class ArticuloItemComponent {
  @Input() blogInfo!: BlogInterface

  constructor(private router: Router){}

}
