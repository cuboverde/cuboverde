import { Component, OnInit } from '@angular/core';
import { CategoryInterface } from '../../interfaces/interfaces';
import { CategoriesService } from '../../services/categories.service';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';



@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [ErrormessageComponent],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit{

  categories: CategoryInterface[] = [];
  public errorMessage!:string;

  constructor(private categoriesService: CategoriesService){}

  ngOnInit(){
    this.categoriesService.getCategory().subscribe ((response: CategoryInterface[]) => {
      this.categories = response;
    }, error => {
      this.errorMessage = error;
    });
  }
}
