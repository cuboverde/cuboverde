import { Component, OnInit, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { PublicationInterface } from '../../interfaces/interfaces';
import { PublicationsService } from '../../services/publications.service';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { AsyncPipe } from '@angular/common';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-publications',
  standalone: true,
  imports: [AsyncPipe, RouterLink, ErrormessageComponent],
  templateUrl: './publications.component.html',
  styleUrl: './publications.component.css'
})
export class PublicationsComponent implements OnInit{

  constructor(private router: Router, private publicationsService: PublicationsService ) {}

  private readonly endPoint = `${environment.apiurl}/publications/`;
  httpClient = inject(HttpClient );
  // article:any = {};
  // id:any= this.route.snapshot.params['id'];

  publications: PublicationInterface[] = [];
  public errorMessage!:string;

  ngOnInit(): void {
    this.publicationsService.getPublications().subscribe((response: PublicationInterface[]) => {
      this.publications = response;
    }, error => {
      this.errorMessage = error;
    });
  }

  apruebaArticulo(id:any): void{
    let resp = this.publicationsService.aprovedPublications(id).subscribe(
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
              text:'Publicacion Aprobada con Exito',
              timer: 3000
            });
            // this.router.navigate(['/dashboard']);
            this.router.navigate(['/publications']);

          }
        }
      })

  }

  muestraError(title:any, text:any, icon:any){
    Swal.fire({
      icon,
      title,
      text,
      confirmButtonText: 'Aceptar'
    });
  }

}
