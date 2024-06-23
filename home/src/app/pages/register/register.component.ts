import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { RegisterService } from '../../services/register.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink, ReactiveFormsModule, FormsModule, HttpClientModule ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  constructor(private registerService: RegisterService, private router: Router){}

  email:string = ""
  password:string = ""
  apellidos:string = ""
  nombres:string = ""
  movil:string = ""


  private readonly _formBuilder = inject(FormBuilder);

  formGroup = this._formBuilder.nonNullable.group({
    email: ['', [Validators.required,Validators.email]],
    userPassword: ['', Validators.required],
    fistName: ['', Validators.required],
    lastName: ['', Validators.required],
    phone: [''],
  })

  enviarRegistro(): void {
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
        userPassword:this.formGroup.controls.userPassword.value,
        fistName:this.formGroup.controls.fistName.value,
        lastName:this.formGroup.controls.lastName.value,
        phone:this.formGroup.controls.phone.value,
      }


      this.registerService.userRegister(user).subscribe(response=>{
        Swal.fire({
          title: 'Atencion',
          text: 'Gracias por Registrarse en nuestra Plataforma,  ',
          icon: 'success',
          confirmButtonText: 'Aceptar',
          timer: 3000
        })
        // router.navigate(['/home'])
        this.router.navigate(['/home'])
        
      }, error=>{
        Swal.fire({
          title: 'Precaucion',
          text: 'A Ocurrido un error al Registrarse, no se pudo realizar el Registro   ',
          icon: 'warning',
          confirmButtonText: 'Aceptar',
          // timer: 1500
        })
        // console.log("Error del servidor",error)
      });
    }
  }

}
