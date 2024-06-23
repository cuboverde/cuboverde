import { Component, inject } from '@angular/core';
import { LogoComponent } from '../../core/logo/logo.component';
import { FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [LogoComponent, ReactiveFormsModule, FormsModule  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {
  
  checked = false;
  indeterminate = false;
  labelPosition: 'before' | 'after' = 'after';
  disabled = false;

  private readonly _formBuilder = inject(FormBuilder);

  formGroup = this._formBuilder.nonNullable.group({
    nombres: ['', Validators.required],
    correo: ['', [Validators.required, Validators.email]],
    telefono: [''],
    asunto: ['', Validators.required],
    mensaje: ['', Validators.required],
    acepto: [true,Validators.required]
  })

  enviarFormulario(): void {
    const nombres = this.formGroup.controls.nombres.value;
    const control = this.formGroup.valid;
    const nameErrors = this.formGroup.errors;
  }

  get nameField(): FormControl <string>{
    return this.formGroup.controls.nombres;
  }

  get emailField(): FormControl<string>{
    return this.formGroup.controls.correo;
  }

  get phoneField(): FormControl<string>{
    return this.formGroup.controls.telefono;
  }

  get asuntoField(): FormControl<string>{
    return this.formGroup.controls.asunto;
  }
  get messageField(): FormControl<string>{
    return this.formGroup.controls.mensaje;
  }

  get aceptoField(): FormControl<boolean>{
    return this.formGroup.controls.acepto;
  }


}
