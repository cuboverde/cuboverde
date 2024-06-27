import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable, catchError } from 'rxjs';
import { CategoriesService } from '../../services/categories.service';
import { CategoriesInterface } from '../../interfaces/interfaces';
import { Router, RouterLink } from '@angular/router';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { AsyncPipe } from '@angular/common';


@Component({
  selector: 'app-tags',
  standalone: true,
  imports: [AsyncPipe,  ErrormessageComponent, RouterLink],
  templateUrl: './tags.component.html',
  styleUrl: './tags.component.css'
})
export class TagsComponent implements OnInit {

  public tagsResults$!: Observable <CategoriesInterface[]>
  public errorMessage!:string;
  constructor(private categoriesService: CategoriesService , private router: Router ){}

  ngOnInit(): void {
    this.tagsResults$ = this.categoriesService.getCategory().pipe(catchError ((error:string) => {
      this.errorMessage = error;
      return EMPTY;
    }));
  }

}
