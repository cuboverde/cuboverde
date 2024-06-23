import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Route, RouterLink } from '@angular/router';
import Swal from 'sweetalert2'
import { LoginService } from '../../services/login.service';
import { first } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, ReactiveFormsModule, FormsModule ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private loginService: LoginService){}

  email:string = ""
  password:string = ""

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
      const user = {
        email:this.formGroup.controls.email.value,
        password:this.formGroup.controls.password.value
      }
      this.iniciarSecion(user)
    }
  }

  iniciarSecion(user:any){
    this.loginService.userlogin(user)
     
  }



}
