import { Component, OnInit, inject } from '@angular/core';
import { CategoriesInterface } from '../../interfaces/interfaces';
import { EMPTY, Observable, catchError } from 'rxjs';
import { CategoriesService } from '../../services/categories.service';
import { Router } from '@angular/router';
import { AsyncPipe } from '@angular/common';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import Swal from 'sweetalert2';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { PublicationsService } from '../../services/publications.service';

@Component({
  selector: 'app-newarticle',
  standalone: true,
  imports: [AsyncPipe, ErrormessageComponent, ReactiveFormsModule , FormsModule ],
  templateUrl: './newarticle.component.html',
  styleUrl: './newarticle.component.css'
})
export class NewarticleComponent implements OnInit{
  public resultArticulo = []
  public tagsResults$!: Observable <CategoriesInterface[]>
  public errorMessage!:string;
  titulo:string = ""
  articulo:string = ""
  categoria:string = ""
  archivo:string = ""

  private readonly _formBuilder = inject (FormBuilder );

  formGroup = this._formBuilder.nonNullable.group({
    titulo: ['', Validators.required],
    articulo: ['', Validators.required],
    categoria: ['', Validators.required],
    archivo: ['', Validators.required],
  })

  constructor(private publicationService:PublicationsService, private categoriesService: CategoriesService, private router: Router ){}

  guardaArticulo(): void {
    if(!this.formGroup.valid){
      this.muestraError('Precaucion','Valide la Informacion Antes de Guardar el Articulo','warning',)
    }else{
      let titlePublication = this.formGroup.controls.titulo.value
      let descriptionPublication = this.formGroup.controls.articulo.value
      let idCategory = this.formGroup.controls.categoria.value
      let images = this.formGroup.controls.archivo.value
      let article = {
        titlePublication,
        descriptionPublication,
        idCategory,
        images,
        idUser: 3,
        approved: 0,
        favorites: 0,
        shared: 0,
        likes: 0,
      }
      this.ingresaArticulo(article)

    }
  }

  ingresaArticulo(article:any){
    let resp = this.publicationService.postPublications(article).subscribe(
    data => {
      if(data== null){
        this.muestraError('Precaucion','Informacion NO Procesada','warning') 
      }else{
        if(Object.keys(data).length == 0 && data.constructor == Object){
          this.muestraError('Precaucion','Informacion NO Procesada','warning') 
        }else{
          Swal.fire({
            icon:'success',
            title:'Atencion',
            text:'Articulo Guardado con Exito',
            timer: 3000
          });
          this.router.navigate(['/publications']);
        }
      }
    })
  }

  traeCategories(){
    this.tagsResults$ = this.categoriesService.getCategory().pipe(catchError ((error:string) => {
      this.errorMessage = error;
      return EMPTY;
    }));

  }

  muestraError(title:any, text:any, icon:any){
    Swal.fire({
      icon,
      title,
      text,
      confirmButtonText: 'Aceptar'
    });
  }

  ngOnInit(): void {
    this.traeCategories()
  }

}
