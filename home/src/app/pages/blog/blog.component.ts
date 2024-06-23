import { Component, OnInit } from '@angular/core';
import { BlogInterface } from '../../interfaces/interfaces';
import { BlogService } from '../../services/blog.service';
import { Router, RouterLink } from '@angular/router';
import { AsyncPipe } from '@angular/common';
import { EMPTY, Observable, catchError } from 'rxjs';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { ArticuloItemComponent } from '../articulo-item/articulo-item.component';


@Component({ 
  selector: 'app-blog',
  standalone: true,
  imports: [AsyncPipe, ErrormessageComponent, ArticuloItemComponent, RouterLink],
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.css'
})
export class BlogComponent implements OnInit{
  public blogResults$!: Observable<BlogInterface[]>
  public errorMessage!:string;
  constructor(private blogService: BlogService, private router: Router){}

  ngOnInit(): void {
    this.blogResults$ = this.blogService.getBlogList().pipe(catchError ((error:string) => {
      this.errorMessage = error;
      return EMPTY;
    }));
  }

  /* irArticulo(id: number) {
    console.log(id)
    this.router.navigate(['/article', id]);
  } */


}
