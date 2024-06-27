import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2'
import { LoginService } from '../../services/login.service';
import { EMPTY, Observable, catchError, first, map } from 'rxjs';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { UserInterface } from '../../interfaces/interfaces';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, ReactiveFormsModule, FormsModule ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public resultLogin = []

  constructor(private loginService: LoginService, private router: Router){}

  email:string = ""
  password:string = ""
  errorMessage:string = ""

  private readonly _formBuilder = inject(FormBuilder);

  formGroup = this._formBuilder.nonNullable.group({
    email: ['', [Validators.required,Validators.email]],
    password: ['', Validators.required]
  })

  enviarLogin(): void {
    if(!this.formGroup.valid){
      Swal.fire({
        title: 'Precaucion',
        text: 'Informacion no Permitida,  ',
        icon: 'error',
        confirmButtonText: 'Aceptar'
      })

    }else{
      let email = this.formGroup.controls.email.value
      let password = this.formGroup.controls.password.value
      this.iniciarSecion(email,password)
    }

  }

  iniciarSecion(email:any, password:any){
    this.loginService.userlogin(email)
    .pipe(first()).subscribe( data => {
      if(data== null){
        muestraError('Precaucion','Usuario o Contraseña Incorrectos','warning') 
        let isLogin  = true
      }else{
        if(Object.keys(data).length == 0 && data.constructor == Object){
          muestraError('Precaucion','No se encontro el usuario','warning') 
        }else{
          if(data.userPassword == password){
            const redirect = this.loginService.redirectUrl || 'dashboard';
            let isLogin  = true
            this.router.navigate([redirect]);
          }else {
            muestraError('Precaucion','Usuario o Contraseña Incorrectos','warning') 
          }
        }
      }
    },
    error =>{
      muestraError('Precaucion','A Ocurrido un Error Durante el inicio de sesion','warning') 
    })

    function muestraError(title:any, text:any, icon:any){
      Swal.fire({
        icon,
        title,
        text,
        confirmButtonText: 'Aceptar'
      });
    }
  }
}
