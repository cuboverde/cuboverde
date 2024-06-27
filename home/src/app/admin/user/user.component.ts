import { AsyncPipe } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { RolesInterface, UserInterface } from '../../interfaces/interfaces';
import { EMPTY, Observable, catchError } from 'rxjs';
import { UsersService } from '../../services/users.service';
import Swal from 'sweetalert2';
import { RolesService } from '../../services/roles.service';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [RouterLink, AsyncPipe, ErrormessageComponent, ReactiveFormsModule , FormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{
  public rolesResults$!: Observable<RolesInterface []>
  public errorMessage!:string;
  password:string = ""
  apellidos:string = ""
  nombres:string = ""
  tipo:string = ""
  correo:string = ""

  private readonly _formBuilder = inject(FormBuilder);

  formGroup = this._formBuilder.nonNullable.group({
    password: ['', Validators.required],
    apellidos: ['', Validators.required],
    nombres: ['', Validators.required],
    tipo: ['', Validators.required],
    correo: ['', [Validators.required, Validators.email]],
    celular: [''],

  })

  constructor(private usersService:UsersService, private rolesService:RolesService, private router: Router ){}

  guardaUsuario(){
    if(!this.formGroup.valid){
      this.muestraError('Precaucion','Valide la Informacion Antes de Guardar el Usuario','warning',)
    }else{
      let fistName = this.formGroup.controls.nombres.value
      let lastName = this.formGroup.controls.apellidos.value
      let phone = this.formGroup.controls.celular.value
      let email = this.formGroup.controls.correo.value
      let idRol = this.formGroup.controls.tipo.value
      let userPassword = this.formGroup.controls.password.value
      let user = {
            fistName,
            lastName,
            phone,
            email,
            idRol,
            userPassword,
          }
      this.ingresaUsuario(user)

    }
  }

  ingresaUsuario(user:any){
    let resp = this.usersService.postUsuarios(user).subscribe(
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
              text:'Usuario Guardado con Exito',
              timer: 3000
            });
            this.router.navigate(['/users']);
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

  ngOnInit(): void {
    this.traeRoles()
  }

  traeRoles(){
    this.rolesResults$ = this.rolesService.getRoles().pipe(catchError ((error:string) => {
      this.errorMessage = error;
      return EMPTY;
    }));

  }


}
